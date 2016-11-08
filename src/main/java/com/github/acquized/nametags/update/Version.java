/* Copyright 2016 Acquized
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.acquized.nametags.update;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Version implements Comparable<Version> {

    public final Pattern SEMVER = Pattern.compile("(?<a>0|[1-9]\\d*)\\.(?<b>0|[1-9]\\d*)(?:\\.(?<c>0|[1-9]\\d*))?(?:-(?<tag>[A-z0-9.-]*))?");
    private int[] parts = new int[3];
    @Getter private String tag;

    public Version(String ver) {
        Matcher matcher = SEMVER.matcher(ver);

        if(!matcher.matches())
            throw new IllegalArgumentException("Input Version doesn't matches SemVer pattern.");

        parts[0] = Integer.parseInt(matcher.group("a"));
        parts[1] = Integer.parseInt(matcher.group("b"));
        parts[2] = Integer.parseInt(matcher.group("c"));

        tag = matcher.group("tag") != null ? matcher.group("tag") : "";
    }

    public static int compare(Version verA, Version verB) {
        if (verA == verB) return 0;
        if (verA == null) return -1;
        if (verB == null) return 1;

        int max = Math.max(verA.parts.length, verB.parts.length);

        for (int i = 0; i < max; i += 1) {
            int partA = i < verA.parts.length ? verA.parts[i] : 0;
            int partB = i < verB.parts.length ? verB.parts[i] : 0;
            if (partA < partB) return -1;
            if (partA > partB) return 1;
        }

        if (verA.tag.length() == 0 && verB.tag.length() > 0)
            return 1;
        if (verA.tag.length() > 0 && verB.tag.length() == 0)
            return -1;
        return 0;
    }

    @Override
    public int compareTo(Version ver) {
        return compare(this, ver);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int part : parts)
            builder.append(part);

        return builder.toString() + (tag.isEmpty() ? "" : "-" + tag);
    }

}