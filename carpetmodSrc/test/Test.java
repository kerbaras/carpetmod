package test;

import it.unimi.dsi.fastutil.HashCommon;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.util.math.ChunkPos;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Test {

    private static final Long2ObjectMap<String> map = new Long2ObjectOpenHashMap<>();

    public static Map<String, Long> profileResults = new HashMap<>();
    public static boolean isFirstBeacon = false;
    public static boolean isGlassRemoved = false;
    public static boolean wasRehashChunkLoaded = false;
    public static boolean loggedRehashBeacon = true;

    public static void main(String[] args) {
        for (int x = -7; x <= 8; x++) {
            for (int z = -21; z <= -6; z++) {
                insert("Spawn chunks", x, z);
            }
        }
        for (int i = 0; i <= 100; i++) {
            insert("Permaloader", -101 - i, 100 + i);
        }

        insert("Cluster chunk", 1, 0);
        insert("Cluster chunk", 1, 7);
        insert("Cluster chunk", 2, 8);
        insert("Cluster chunk", 3, -1);
        insert("Cluster chunk", 3, 4);
        insert("Cluster chunk", 3, 9);
        insert("Cluster chunk", 4, 0);
        insert("Cluster chunk", 4, 2);
        insert("Cluster chunk", 5, -1);
        insert("Cluster chunk", 5, 4);
        insert("Cluster chunk", 6, 5);
        insert("Cluster chunk", 8, 7);
        insert("Cluster chunk", 9, -3);
        insert("Cluster chunk", 9, 2);
        insert("Cluster chunk", 9, 7);
        insert("Cluster chunk", 11, -3);
        insert("Cluster chunk", 11, -2);
        insert("Cluster chunk", 11, 2);
        insert("Cluster chunk", 11, 5);
        insert("Cluster chunk", 11, 7);
        insert("Cluster chunk", 12, -1);
        insert("Cluster chunk", 13, 5);
        insert("Cluster chunk", 14, -1);
        insert("Cluster chunk", 14, 4);
        insert("Cluster chunk", 15, 0);
        insert("Cluster chunk", 15, 10);
        insert("Cluster chunk", 16, 2);
        insert("Cluster chunk", 16, 8);
        insert("Cluster chunk", 17, 2);
        insert("Cluster chunk", 18, 3);
        insert("Cluster chunk", 19, -3);
        insert("Cluster chunk", 19, 7);
        insert("Cluster chunk", 20, 11);
        insert("Cluster chunk", 21, -2);
        insert("Cluster chunk", 21, 3);
        insert("Cluster chunk", 21, 8);
        insert("Cluster chunk", 22, 0);
        insert("Cluster chunk", 22, 1);
        insert("Cluster chunk", 22, 6);
        insert("Cluster chunk", 22, 11);
        insert("Cluster chunk", 24, 0);
        insert("Cluster chunk", 24, 4);
        insert("Cluster chunk", 25, -4);
        insert("Cluster chunk", 25, -1);
        insert("Cluster chunk", 25, 4);
        insert("Cluster chunk", 25, 6);
        insert("Cluster chunk", 25, 11);
        insert("Cluster chunk", 26, 4);
        insert("Cluster chunk", 27, 0);
        insert("Cluster chunk", 27, 5);
        insert("Cluster chunk", 28, -1);
        insert("Cluster chunk", 28, 7);
        insert("Cluster chunk", 28, 9);
        insert("Cluster chunk", 29, -4);
        insert("Cluster chunk", 29, -1);
        insert("Cluster chunk", 29, 0);
        insert("Cluster chunk", 30, 4);
        insert("Cluster chunk", 30, 9);
        insert("Cluster chunk", 31, -2);
        insert("Cluster chunk", 31, -1);
        insert("Cluster chunk", 31, 4);
        insert("Cluster chunk", 31, 9);
        insert("Cluster chunk", 32, -4);
        insert("Cluster chunk", 32, 3);
        insert("Cluster chunk", 32, 10);
        insert("Cluster chunk", 33, 0);
        insert("Cluster chunk", 33, 7);
        insert("Cluster chunk", 34, 0);
        insert("Cluster chunk", 35, 0);
        insert("Cluster chunk", 37, 1);
        insert("Cluster chunk", 37, 5);
        insert("Cluster chunk", 37, 6);
        insert("Cluster chunk", 38, 0);
        insert("Cluster chunk", 38, 6);
        insert("Cluster chunk", 39, -4);
        insert("Cluster chunk", 39, 3);
        insert("Cluster chunk", 39, 10);
        insert("Cluster chunk", 40, 5);
        insert("Cluster chunk", 41, -2);
        insert("Cluster chunk", 41, 8);
        insert("Cluster chunk", 42, 0);
        insert("Cluster chunk", 42, 4);
        insert("Cluster chunk", 42, 7);
        insert("Cluster chunk", 43, -1);
        insert("Cluster chunk", 43, 4);
        insert("Cluster chunk", 43, 6);
        insert("Cluster chunk", 43, 9);
        insert("Cluster chunk", 44, 1);
        insert("Cluster chunk", 44, 8);
        insert("Cluster chunk", 45, -2);
        insert("Cluster chunk", 45, 8);
        insert("Cluster chunk", 45, 9);
        insert("Cluster chunk", 47, -3);
        insert("Cluster chunk", 47, -2);
        insert("Cluster chunk", 47, 5);
        insert("Cluster chunk", 47, 7);
        insert("Cluster chunk", 48, -1);
        insert("Cluster chunk", 48, 6);
        insert("Cluster chunk", 49, -1);
        insert("Cluster chunk", 49, 4);
        insert("Cluster chunk", 50, 1);
        insert("Cluster chunk", 50, 11);
        insert("Cluster chunk", 52, 3);
        insert("Cluster chunk", 52, 4);
        insert("Cluster chunk", 53, -2);
        insert("Cluster chunk", 54, -1);
        insert("Cluster chunk", 54, 4);
        insert("Cluster chunk", 56, -1);
        insert("Cluster chunk", 56, 9);
        insert("Cluster chunk", 57, -4);
        insert("Cluster chunk", 57, 6);
        insert("Cluster chunk", 57, 9);
        insert("Cluster chunk", 58, -1);
        insert("Cluster chunk", 58, 3);
        insert("Cluster chunk", 59, -2);
        insert("Cluster chunk", 59, 9);
        insert("Cluster chunk", 60, 0);
        insert("Cluster chunk", 60, 4);
        insert("Cluster chunk", 61, -4);
        insert("Cluster chunk", 61, -1);
        insert("Cluster chunk", 61, 4);
        insert("Cluster chunk", 61, 9);
        insert("Cluster chunk", 61, 10);
        insert("Cluster chunk", 62, 5);
        insert("Cluster chunk", 63, 1);
        insert("Cluster chunk", 63, 11);
        insert("Cluster chunk", 64, 0);
        insert("Cluster chunk", 65, 0);
        insert("Cluster chunk", 65, 10);
        insert("Cluster chunk", 66, 5);
        insert("Cluster chunk", 67, -3);
        insert("Cluster chunk", 67, -2);
        insert("Cluster chunk", 67, 9);
        insert("Cluster chunk", 68, -3);
        insert("Cluster chunk", 68, -1);
        insert("Cluster chunk", 69, -3);
        insert("Cluster chunk", 69, 0);
        insert("Cluster chunk", 69, 4);
        insert("Cluster chunk", 69, 5);
        insert("Cluster chunk", 69, 10);
        insert("Cluster chunk", 71, 6);
        insert("Cluster chunk", 72, 2);
        insert("Cluster chunk", 72, 3);
        insert("Cluster chunk", 73, -3);
        insert("Cluster chunk", 73, 8);
        insert("Cluster chunk", 74, -4);
        insert("Cluster chunk", 74, 4);
        insert("Cluster chunk", 74, 8);
        insert("Cluster chunk", 75, -4);
        insert("Cluster chunk", 75, 0);
        insert("Cluster chunk", 75, 5);
        insert("Cluster chunk", 75, 6);
        insert("Cluster chunk", 76, -1);
        insert("Cluster chunk", 76, 1);
        insert("Cluster chunk", 76, 6);
        insert("Cluster chunk", 77, 11);
        insert("Cluster chunk", 78, -3);
        insert("Cluster chunk", 78, 0);
        insert("Cluster chunk", 78, 10);
        insert("Cluster chunk", 79, -3);
        insert("Cluster chunk", 79, 1);
        insert("Cluster chunk", 79, 2);
        insert("Cluster chunk", 79, 11);
        insert("Cluster chunk", 81, -4);
        insert("Cluster chunk", 81, -1);
        insert("Cluster chunk", 81, 6);
        insert("Cluster chunk", 82, -1);
        insert("Cluster chunk", 83, 5);
        insert("Cluster chunk", 83, 7);
        insert("Cluster chunk", 83, 10);
        insert("Cluster chunk", 84, 2);
        insert("Cluster chunk", 84, 4);
        insert("Cluster chunk", 85, 0);
        insert("Cluster chunk", 85, 2);
        insert("Cluster chunk", 85, 9);
        insert("Cluster chunk", 85, 10);
        insert("Cluster chunk", 86, -3);
        insert("Cluster chunk", 86, -1);
        insert("Cluster chunk", 87, -4);
        insert("Cluster chunk", 87, 0);
        insert("Cluster chunk", 87, 7);
        insert("Cluster chunk", 88, -4);
        insert("Cluster chunk", 88, 7);
        insert("Cluster chunk", 88, 8);
        insert("Cluster chunk", 89, 0);
        insert("Cluster chunk", 89, 5);
        insert("Cluster chunk", 89, 10);
        insert("Cluster chunk", 93, 7);
        insert("Cluster chunk", 97, -4);
        insert("Cluster chunk", 97, 0);
        insert("Cluster chunk", 98, 2);
        insert("Cluster chunk", 99, -1);
        insert("Cluster chunk", 99, 9);
        insert("Cluster chunk", 100, 5);
        insert("Cluster chunk", 101, -3);
        insert("Cluster chunk", 101, 4);
        insert("Cluster chunk", 102, -4);
        insert("Cluster chunk", 102, 3);
        insert("Cluster chunk", 103, 11);
        insert("Cluster chunk", 104, -4);
        insert("Cluster chunk", 104, 1);
        insert("Cluster chunk", 104, 5);
        insert("Cluster chunk", 105, -2);
        insert("Cluster chunk", 105, 6);
        insert("Cluster chunk", 105, 8);
        insert("Cluster chunk", 106, -3);
        insert("Cluster chunk", 106, 1);
        insert("Cluster chunk", 106, 4);
        insert("Cluster chunk", 106, 11);
        insert("Cluster chunk", 107, 1);
        insert("Cluster chunk", 107, 11);
        insert("Cluster chunk", 108, 1);
        insert("Cluster chunk", 108, 2);
        insert("Cluster chunk", 108, 9);
        insert("Cluster chunk", 109, 3);
        insert("Cluster chunk", 109, 6);
        insert("Cluster chunk", 110, 4);
        insert("Cluster chunk", 111, -3);
        insert("Cluster chunk", 112, -1);
        insert("Cluster chunk", 112, 6);
        insert("Cluster chunk", 113, -3);
        insert("Cluster chunk", 113, -1);
        insert("Cluster chunk", 113, 7);
        insert("Cluster chunk", 114, -2);
        insert("Cluster chunk", 114, -1);
        insert("Cluster chunk", 114, 3);
        insert("Cluster chunk", 114, 8);
        insert("Cluster chunk", 115, 2);
        insert("Cluster chunk", 115, 9);
        insert("Cluster chunk", 116, -3);
        insert("Cluster chunk", 116, 7);
        insert("Cluster chunk", 117, -3);
        insert("Cluster chunk", 117, 3);
        insert("Cluster chunk", 117, 7);
        insert("Cluster chunk", 117, 8);
        insert("Cluster chunk", 118, -3);
        insert("Cluster chunk", 121, 4);
        insert("Cluster chunk", 121, 8);
        insert("Cluster chunk", 122, 2);
        insert("Cluster chunk", 122, 6);
        insert("Cluster chunk", 122, 9);
        insert("Cluster chunk", 123, -1);
        insert("Cluster chunk", 123, 3);
        insert("Cluster chunk", 123, 8);
        insert("Cluster chunk", 124, 4);
        insert("Cluster chunk", 124, 11);
        insert("Cluster chunk", 125, -2);
        insert("Cluster chunk", 125, -1);
        insert("Cluster chunk", 126, 3);
        insert("Cluster chunk", 126, 7);
        insert("Cluster chunk", 126, 8);
        insert("Cluster chunk", 127, -1);
        insert("Cluster chunk", 127, 7);
        insert("Cluster chunk", 127, 9);
        insert("Cluster chunk", 128, -1);
        insert("Cluster chunk", 128, 8);
        insert("Cluster chunk", 128, 9);
        insert("Cluster chunk", 129, 2);
        insert("Cluster chunk", 129, 4);
        insert("Cluster chunk", 130, 4);
        insert("Cluster chunk", 130, 8);
        insert("Cluster chunk", 130, 11);
        insert("Cluster chunk", 131, 4);
        insert("Cluster chunk", 132, 1);
        insert("Cluster chunk", 132, 6);
        insert("Cluster chunk", 133, 2);
        insert("Cluster chunk", 133, 8);
        insert("Cluster chunk", 134, -3);
        insert("Cluster chunk", 134, 0);
        insert("Cluster chunk", 134, 10);
        insert("Cluster chunk", 135, -1);
        insert("Cluster chunk", 136, -1);
        insert("Cluster chunk", 136, 0);
        insert("Cluster chunk", 136, 4);
        insert("Cluster chunk", 136, 9);
        insert("Cluster chunk", 137, -4);
        insert("Cluster chunk", 137, -3);
        insert("Cluster chunk", 138, -2);
        insert("Cluster chunk", 138, 4);
        insert("Cluster chunk", 138, 9);
        insert("Cluster chunk", 139, -2);
        insert("Cluster chunk", 139, 10);
        insert("Cluster chunk", 141, 0);
        insert("Cluster chunk", 142, -1);
        insert("Cluster chunk", 142, 2);
        insert("Cluster chunk", 143, 5);
        insert("Cluster chunk", 143, 9);
        insert("Cluster chunk", 144, 3);
        insert("Cluster chunk", 144, 7);
        insert("Cluster chunk", 144, 8);
        insert("Cluster chunk", 145, -1);
        insert("Cluster chunk", 145, 3);
        insert("Cluster chunk", 147, -1);
        insert("Cluster chunk", 148, 5);
        insert("Cluster chunk", 148, 10);
        insert("Cluster chunk", 149, -1);
        insert("Cluster chunk", 149, 4);
        insert("Cluster chunk", 149, 9);
        insert("Cluster chunk", 150, -4);
        insert("Cluster chunk", 150, 4);
        insert("Cluster chunk", 151, -2);
        insert("Cluster chunk", 151, 3);
        insert("Cluster chunk", 151, 5);
        insert("Cluster chunk", 151, 8);
        insert("Cluster chunk", 152, -1);
        insert("Cluster chunk", 154, 4);
        insert("Cluster chunk", 155, -2);
        insert("Cluster chunk", 155, 2);
        insert("Cluster chunk", 155, 7);
        insert("Cluster chunk", 155, 8);
        insert("Cluster chunk", 156, 8);
        insert("Cluster chunk", 157, -4);
        insert("Cluster chunk", 157, 6);
        insert("Cluster chunk", 157, 11);
        insert("Cluster chunk", 158, -2);
        insert("Cluster chunk", 160, 10);
        insert("Cluster chunk", 161, -2);
        insert("Cluster chunk", 161, -1);
        insert("Cluster chunk", 161, 5);
        insert("Cluster chunk", 161, 9);
        insert("Cluster chunk", 162, 4);
        insert("Cluster chunk", 162, 9);
        insert("Cluster chunk", 162, 11);
        insert("Cluster chunk", 163, 3);
        insert("Cluster chunk", 164, -1);
        insert("Cluster chunk", 164, 9);
        insert("Cluster chunk", 165, 5);
        insert("Cluster chunk", 165, 8);
        insert("Cluster chunk", 166, 4);
        insert("Cluster chunk", 166, 8);
        insert("Cluster chunk", 167, -3);
        insert("Cluster chunk", 167, 9);
        insert("Cluster chunk", 168, -4);
        insert("Cluster chunk", 169, 2);
        insert("Cluster chunk", 170, 1);
        insert("Cluster chunk", 170, 6);
        insert("Cluster chunk", 171, 5);
        insert("Cluster chunk", 171, 10);
        insert("Cluster chunk", 172, 5);
        insert("Cluster chunk", 174, 10);
        insert("Cluster chunk", 174, 11);
        insert("Cluster chunk", 175, 0);
        insert("Cluster chunk", 176, 0);
        insert("Cluster chunk", 176, 1);
        insert("Cluster chunk", 176, 5);
        insert("Cluster chunk", 176, 6);
        insert("Cluster chunk", 178, 9);
        insert("Cluster chunk", 179, -2);
        insert("Cluster chunk", 179, 4);
        insert("Cluster chunk", 180, 4);
        insert("Cluster chunk", 183, 6);
        insert("Cluster chunk", 183, 10);
        insert("Cluster chunk", 183, 11);
        insert("Cluster chunk", 184, -4);
        insert("Cluster chunk", 184, 6);
        insert("Cluster chunk", 184, 10);
        insert("Cluster chunk", 185, 4);
        insert("Cluster chunk", 186, 1);
        insert("Cluster chunk", 186, 8);
        insert("Cluster chunk", 187, 6);
        insert("Cluster chunk", 188, 11);
        insert("Cluster chunk", 189, 5);
        insert("Cluster chunk", 189, 10);
        insert("Cluster chunk", 190, 0);
        insert("Cluster chunk", 190, 5);
        insert("Cluster chunk", 191, -4);
        insert("Cluster chunk", 192, 2);
        insert("Cluster chunk", 194, -3);
        insert("Cluster chunk", 194, 2);
        insert("Cluster chunk", 194, 7);
        insert("Cluster chunk", 195, -3);
        insert("Cluster chunk", 195, -2);
        insert("Cluster chunk", 195, 2);
        insert("Cluster chunk", 196, -1);
        insert("Cluster chunk", 196, 10);
        insert("Cluster chunk", 197, 0);
        insert("Cluster chunk", 197, 2);
        insert("Cluster chunk", 197, 7);
        insert("Cluster chunk", 198, 1);
        insert("Cluster chunk", 198, 8);
        insert("Cluster chunk", 199, 0);
        insert("Cluster chunk", 199, 4);
        insert("Cluster chunk", 199, 5);
        insert("Cluster chunk", 200, -4);
        insert("Cluster chunk", 200, 4);
        insert("Cluster chunk", 200, 6);
        insert("Cluster chunk", 201, 5);
        insert("Cluster chunk", 201, 6);
        insert("Cluster chunk", 201, 10);
        insert("Cluster chunk", 202, 0);
        insert("Cluster chunk", 202, 5);
        insert("Cluster chunk", 203, 1);
        insert("Cluster chunk", 203, 5);
        insert("Cluster chunk", 203, 10);
        insert("Cluster chunk", 204, 0);
        insert("Cluster chunk", 204, 5);
        insert("Cluster chunk", 204, 7);
        insert("Cluster chunk", 205, -3);
        insert("Cluster chunk", 205, 4);
        insert("Cluster chunk", 205, 8);
        insert("Cluster chunk", 206, -4);
        insert("Cluster chunk", 206, -1);
        insert("Cluster chunk", 207, -4);
        insert("Cluster chunk", 207, 3);
        insert("Cluster chunk", 208, -4);
        insert("Cluster chunk", 208, 11);
        insert("Cluster chunk", 212, 1);
        insert("Cluster chunk", 212, 11);
        insert("Cluster chunk", 213, -4);
        insert("Cluster chunk", 213, 4);
        insert("Cluster chunk", 214, -4);
        insert("Cluster chunk", 214, 3);
        insert("Cluster chunk", 214, 10);
        insert("Cluster chunk", 215, 3);
        insert("Cluster chunk", 215, 4);
        insert("Cluster chunk", 215, 8);
        insert("Cluster chunk", 217, -2);
        insert("Cluster chunk", 217, -1);
        insert("Cluster chunk", 217, 3);
        insert("Cluster chunk", 219, 1);
        insert("Cluster chunk", 219, 3);
        insert("Cluster chunk", 219, 7);
        insert("Cluster chunk", 220, 2);
        insert("Cluster chunk", 221, 2);
        insert("Cluster chunk", 221, 7);
        insert("Cluster chunk", 222, -3);
        insert("Cluster chunk", 222, 5);
        insert("Cluster chunk", 222, 7);
        insert("Cluster chunk", 223, -2);
        insert("Cluster chunk", 224, -1);
        insert("Cluster chunk", 225, -4);
        insert("Cluster chunk", 226, 6);
        insert("Cluster chunk", 226, 8);
        insert("Cluster chunk", 228, -3);
        insert("Cluster chunk", 228, 4);
        insert("Cluster chunk", 228, 11);
        insert("Cluster chunk", 229, -3);
        insert("Cluster chunk", 229, 4);
        insert("Cluster chunk", 230, -2);
        insert("Cluster chunk", 231, -1);
        insert("Cluster chunk", 231, 8);
        insert("Cluster chunk", 231, 9);
        insert("Cluster chunk", 232, 8);
        insert("Cluster chunk", 233, 11);

        for (int i = 0; i < 33 * 33 + 2; i++) {
            insert("Temp", 10000, i);
        }
        for (int i = 0; i < 33 * 33 + 2; i++) {
            map.remove(ChunkPos.asLong(10000, i));
        }

        insert("Bait chunk", -3, -40);

        insert("Glass chunk", 100, 100);

        insert("Swap chunk", 95, 120);

        for (int dx = -16; dx <= 16; dx++) {
            for (int dz = -16; dz <= 16; dz++) {
                if (dx != 0 || dz != 0) {
                    insert("Render distance", 100 + dx, 100 + dz);
                }
            }
        }

        long[] key;
        Object[] value;
        try {
            Field field = Long2ObjectOpenHashMap.class.getDeclaredField("value");
            field.setAccessible(true);
            value = (Object[]) field.get(map);
            field = Long2ObjectOpenHashMap.class.getDeclaredField("key");
            field.setAccessible(true);
            key = (long[]) field.get(map);
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(e);
        }

        for (int i = 0; i < value.length; i++) {
            System.out.println(i + ": " + value[i] + " " + (HashCommon.mix(key[i]) & (value.length - 2)));
        }

        System.out.println(map.size());
    }

    private static void insert(String comment, int cx, int cz) {
        map.put(ChunkPos.asLong(cx, cz), comment + ": (" + cx + ", " + cz + ")");
    }

}
