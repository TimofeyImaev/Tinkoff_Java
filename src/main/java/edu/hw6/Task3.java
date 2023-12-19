package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Task3 {
    public static abstract class AbstractFilter implements DirectoryStream.Filter<Path> {
        protected AbstractFilter next;

        public void setNext(AbstractFilter next) {
            this.next = next;
        }

        public AbstractFilter and(AbstractFilter readable) {
            readable.setNext(this);

            return readable;
        }
    }

    public static class AttributeFilter extends AbstractFilter {
        private final String attribute;

        public AttributeFilter(String attribute) {
            this.attribute = attribute;
        }

        @Override
        public boolean accept(Path entry) throws IOException {
            if (next != null && !next.accept(entry)) {
                return false;
            }

            return switch (attribute) {
                case "readable" -> Files.isReadable(entry);
                case "writable" -> Files.isWritable(entry);
                default -> false;
            };
        }
    }

    public static class SizeFilter extends AbstractFilter {
        private Integer maxSize;
        private Integer minSize;

        @Override
        public boolean accept(Path entry) throws IOException {
            if (next != null && !next.accept(entry)) {
                return false;
            }
            long size = Files.size(entry);

            boolean isMoreThenMinSize = (minSize == null) || (minSize <= size);
            boolean isLessThenMaxSize = (maxSize == null) || (maxSize >= size);

            return isMoreThenMinSize && isLessThenMaxSize;
        }

        public void setMaxSize(Integer maxSize) {
            this.maxSize = maxSize;
        }

        public void setMinSize(Integer minSize) {
            this.minSize = minSize;
        }
    }

    public static class RegexFilter extends AbstractFilter {
        Pattern pattern;

        public RegexFilter(String regex) {
            this.pattern = Pattern.compile(regex);
        }

        @Override
        public boolean accept(Path entry) throws IOException {
            if (next != null && !next.accept(entry)) {
                return false;
            }

            return pattern.matcher(entry.getFileName().toString()).matches();
        }
    }

    public static class MagicNumbersFilter extends AbstractFilter {
        private final static int MAX_BYTE_VALUE = 0xFF;
        Integer magicNumber;

        public MagicNumbersFilter(Integer magicNumber) {
            this.magicNumber = magicNumber;
        }

        @Override
        public boolean accept(Path entry) throws IOException {
            if (next != null && !next.accept(entry)) {
                return false;
            }

            return (Files.readAllBytes(entry)[0] & MAX_BYTE_VALUE) == magicNumber;
        }
    }

    public static class FileExtensionsFilter extends AbstractFilter {
        Pattern pattern;

        public FileExtensionsFilter(String regex) {
            this.pattern = Pattern.compile(".*\\." + regex + "$");
        }

        @Override
        public boolean accept(Path entry) throws IOException {
            if (next != null && !next.accept(entry)) {
                return false;
            }

            return pattern.matcher(entry.getFileName().toString()).matches();
        }
    }
}
