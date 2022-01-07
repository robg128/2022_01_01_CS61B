public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    static double G = 6.67e-11;

    public Planet(double xxPos, double yyPos, double xxVel,
                  double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /** Calculate the Distance between this and Planet p2*/
    public double calcDistance(Planet p2) {
        double xtempx = Math.abs(xxPos - p2.xxPos);
        double ytempy = Math.abs(yyPos - p2.yyPos);

        return Math.sqrt((xtempx * xtempx) + (ytempy * ytempy));
    }

    /** Calculate the Force between this and p2 */
    public double calcForceExertedBy(Planet p2) {
        double rSquare = Math.pow(this.calcDistance(p2), 2);
        
        return (G * this.mass * p2.mass) / rSquare;
    }

    /** Calculate the Component in the X direction of the Force */
    public double calcForceExertedByX(Planet p2) {
        double dx = p2.xxPos - xxPos;
        double F = this.calcForceExertedBy(p2);

        return (F * dx) / this.calcDistance(p2);
    }

    /** Calculate the Component in the Y direction of the Force */
    public double calcForceExertedByY(Planet p2) {
        double dy = p2.yyPos - yyPos;
        double F = this.calcForceExertedBy(p2);

        return (F * dy) / this.calcDistance(p2);
    }

    /** Calculate the net Force in the X direction of the Net Force */
    public double calcNetForceExertedByX(Planet[] array) {
        double XNetForce = 0;
        for (int i = 0; i < array.length; i++) {
            /** If array[i] as same as this, then skip */
            if (this.equals(array[i]) == true) {
                continue;
            }
            XNetForce += this.calcForceExertedByX(array[i]);
        }
        return XNetForce;
    }

    /** Calculate the net Force in the Y direction of the Net Force */
    public double calcNetForceExertedByY(Planet[] array) {
        double YNetForce = 0;
        for (int i = 0; i < array.length; i++) {
            if (this.equals(array[i]) == true) {
                continue;
            }
            YNetForce += this.calcForceExertedByY(array[i]);
        }
        return YNetForce;
    }

    /** Update the planet's position and velocity instance variables */
    public void update(double t, double fX, double fY) {
        double aNetX = fX / this.mass;
        double aNetY = fY / this.mass;

        this.xxVel = this.xxVel + aNetX * t;
        this.yyVel = this.yyVel + aNetY * t;

        this.xxPos = this.xxPos + this.xxVel * t;
        this.yyPos = this.yyPos + this.yyVel * t;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
//        StdDraw.show();
    }
}
