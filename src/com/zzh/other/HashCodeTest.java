package com.zzh.other;

import java.util.Objects;

/**
 * @author zhangzhihao
 * @date 2020/10/9 10:36
 */
public class HashCodeTest {
    private String aaa;
    private Integer bbb;
    private Boolean ccc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCodeTest that = (HashCodeTest) o;
        return Objects.equals(aaa, that.aaa) &&
                Objects.equals(bbb, that.bbb) &&
                Objects.equals(ccc, that.ccc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aaa, bbb, ccc);
    }

    public HashCodeTest(String aaa, Integer bbb, Boolean ccc) {
        this.aaa = aaa;
        this.bbb = bbb;
        this.ccc = ccc;
    }

    public static void main(String[] args) {
        HashCodeTest hashCodeTest = new HashCodeTest("aaa", 111, false);
        HashCodeTest hashCodeTest1 = new HashCodeTest("aaa", 111, false);
        System.out.println(hashCodeTest.hashCode());
        System.out.println(hashCodeTest1.hashCode());
    }
}
