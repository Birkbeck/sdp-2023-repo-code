package reflection.question2;

class Point {
    private final double x, y;
    public Point(int x, int y) { this.x = x; this. y = y; }
    public Point(String s) {
        if (s.charAt(0) != '(' || s.charAt(s.length() - 1) != ')')
            throw new IllegalArgumentException("Invalid point format " + s);
        String[] split = s.substring(1, s.length() -1 ).split(",");
        if (split.length != 2)
            throw new IllegalArgumentException("Invalid Point format " + s);
        this.x = Integer.parseInt(split[0].trim());
        this.y = Integer.parseInt(split[1].trim());
    }
    // other methods here
}