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

import java.nio.file.Path;

/**
 * Unpack an archive.
 *
 * @author Grégory Van den Borre
 */
public interface Unpacker {

    /**
     * Extract a directory and all its content from an archive.
     *
     * @param archive     Zip file to extract the data from.
     * @param destination Path where the directory will be extracted.
     * @param keepRootDir Keep the root directory or extract all its content.
     * @throws IllegalStateException If the archive file does not exist.
     */
    void unpack(Path archive, Path destination, boolean keepRootDir);

    /**
     * Extract a directory and all its content from an archive.
     *
     * @param archive     Zip file to extract the data from.
     * @param destination Path where the directory will be extracted.
     * @param keepRootDir Keep the root directory or extract all its content.
     * @param discardSubDirectories Decide to keep subdirectories or to push all files into the root path.
     * @throws IllegalStateException If the archive file does not exist.
     */
    void unpack(Path archive, Path destination, boolean keepRootDir, boolean discardSubDirectories);


    void unpack(Path archive, String fileToExtract, Path destination);

    /**
     * Extract a directory and all its content from an archive file.
     *
     * @param archive            Archive file to extract the data from.
     * @param directoryToExtract Directory to extract.
     * @param destination        Path where the directory will be extracted.
     * @throws IllegalStateException If the archive file does not exist.
     */
    void unpackDirectoryToDirectory(Path archive, String directoryToExtract, Path destination);
}
