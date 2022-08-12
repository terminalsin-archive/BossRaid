package dev.ghast.bossraid.util;

public class Region3i {
    private Vec3i a;
    private Vec3i b;

    public Region3i(Vec3i a, Vec3i b) {
        this.a = a;
        this.b = b;
    }

    public Vec3i getA() {
        return a;
    }

    public void setA(Vec3i a) {
        this.a = a;
    }

    public Vec3i getB() {
        return b;
    }

    public void setB(Vec3i b) {
        this.b = b;
    }

    public int getMinX() {
        return Math.min(a.getX(), b.getX());
    }

    public int getMinY() {
        return Math.min(a.getY(), b.getY());
    }

    public int getMinZ() {
        return Math.min(a.getZ(), b.getZ());
    }

    public int getMaxX() {
        return Math.max(a.getX(), b.getX());
    }

    public int getMaxY() {
        return Math.max(a.getY(), b.getY());
    }

    public int getMaxZ() {
        return Math.max(a.getZ(), b.getZ());
    }
}
