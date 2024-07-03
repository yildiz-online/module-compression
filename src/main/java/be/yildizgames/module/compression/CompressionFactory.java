/*
 This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 Copyright (c) 2018-2024 Grégory Van den Borre
 More infos available: https://engine.yildiz-games.be
 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to the following conditions: The above copyright
 notice and this permission notice shall be included in all copies or substantial portions of the  Software.
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package be.yildizgames.module.compression;

import be.yildizgames.common.types.FileTypeCategories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.ServiceLoader;

/**
 * This class is an entry point for this module, it exposes utilities: archivers, unpackers, file info.
 * This class is not mutable.
 * This class does not allow null input.
 * This class never returns null values.
 *
 * @author Grégory Van den Borre
 */
public class CompressionFactory {

    static FileInfoRetrieverProvider getFileInfoRetrieverProvider() {
        return ServiceLoader.load(FileInfoRetrieverProvider.class)
                .findFirst().orElseThrow();
    }

    static ArchiverProvider getArchiverProvider() {
        return ServiceLoader.load(ArchiverProvider.class)
                .findFirst().orElseThrow();
    }


    private CompressionFactory() {
        super();
    }



    public static boolean isArchive(Path path) {
        try {
            return FileTypeCategories.ARCHIVES.is(Files.newInputStream(Objects.requireNonNull(path))).isPresent();
        } catch (IOException e) {
            System.getLogger(CompressionFactory.class.getName()).log(System.Logger.Level.ERROR, "", e);
        }
        return false;
    }

    public static FileInfoRetriever fileInfo(Path path) {
        return getFileInfoRetrieverProvider().getFileInfoRetriever(path);
    }

    public static Archiver archiver() {
        return getArchiverProvider().getArchiver();
    }
}
