package records.five;

record Rectangle(double length, double width) {
    // Public instance method
    public Rectangle getRotatedRectangleBoundingBox(double degrees) {
        RotationAngle ra = RotationAngle.inDegrees(degrees);
        double x = Math.abs(length * Math.cos(ra.angle())) +
            Math.abs(width * Math.sin(ra.angle()));
        double y = Math.abs(length * Math.sin(ra.angle())) +
            Math.abs(width * Math.cos(ra.angle()));
        return new Rectangle(x, y);
    }

    // Nested record class
    record RotationAngle(double angle) {

        static RotationAngle inDegrees(double degrees) {
            return new RotationAngle(Math.toRadians(degrees));
        }
    }
}