package carpet.utils;

import it.unimi.dsi.fastutil.HashCommon;

public class Long2ObjectOpenHashMap<V> extends it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap<V> {

    public Long2ObjectOpenHashMap(int expected) {
        super(expected);
    }

    protected void newShiftKeys(int pos) {
        long[] key = this.key;

        while(true) {
            int last = pos;
            pos = pos + 1 & this.mask;

            long curr;
            while(true) {
                if ((curr = key[pos]) == 0L) {
                    key[last] = 0L;
                    this.value[last] = null;
                    return;
                }

                int slot = (int) HashCommon.mix(curr) & this.mask;
                if (last <= pos) {
                    if (last >= slot || slot > pos) {
                        break;
                    }
                } else if (last >= slot && slot > pos) {
                    break;
                }

                pos = pos + 1 & this.mask;
            }

            key[last] = curr;
            this.value[last] = this.value[pos];
        }
    }

    private V removeEntry(final int pos) {

        final V oldValue = this.value[pos];
        value[pos] = null;
        size--;
        newShiftKeys(pos);
        if (size < maxFill / 4 && n > DEFAULT_INITIAL_SIZE) rehash(n / 2);
        return oldValue;
    }

    private V removeNullEntry() {
        this.containsNullKey = false;
        V oldValue = this.value[this.n];
        this.value[this.n] = null;
        --this.size;
        if (this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }

        return oldValue;
    }

    public V remove(long k) {
        if (k == 0L) {
            return this.containsNullKey ? this.removeNullEntry() : this.defRetValue;
        } else {
            long[] key = this.key;
            long curr;
            int pos;
            if ((curr = key[pos = (int)HashCommon.mix(k) & this.mask]) == 0L) {
                return this.defRetValue;
            } else if (k == curr) {
                return this.removeEntry(pos);
            } else {
                while((curr = key[pos = pos + 1 & this.mask]) != 0L) {
                    if (k == curr) {
                        return this.removeEntry(pos);
                    }
                }

                return this.defRetValue;
            }
        }
    }

    public V get(long k) {
        if (k == 0L) {
            return this.containsNullKey ? this.value[this.n] : this.defRetValue;
        } else {
            long[] key = this.key;
            long curr;
            int pos;
            if ((curr = key[pos = (int)HashCommon.mix(k) & this.mask]) == 0L) {
                return this.defRetValue;
            } else if (k == curr) {
                return this.value[pos];
            } else {
                while((curr = key[pos = pos + 1 & this.mask]) != 0L) {
                    if (k == curr) {
                        return this.value[pos];
                    }
                }

                return this.defRetValue;
            }
        }
    }
}
