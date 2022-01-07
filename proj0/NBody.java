public class NBody {
    public static String imageBackground = "images/starfield.jpg";

    /**  read form fileName to get the Radius */
    public static double readRadius(String fileName) {
        In in = new In(fileName);

        int PlanetNum = in.readInt();
        double Radius = in.readDouble();
        
        return Radius;
    }

    /**  read from the fileName to get the planets' information */
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);

        int PlanetNum = in.readInt();
        double Radius = in.readDouble();

        Planet[] Planetss = new Planet[PlanetNum];
        for (int i = 0; i < PlanetNum && in.isEmpty() == false; i++) {

            Planetss[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), 
                                    in.readDouble(), in.readDouble(), in.readString());
            
            /** If there is a high-level constructor, 
             * there is no default(low-level) constructor */
            // Planetss[i].xxPos = in.readDouble();
            // Planetss[i].yyPos = in.readDouble();
            // Planetss[i].xxVel = in.readDouble();
            // Planetss[i].yyVel = in.readDouble();
            // Planetss[i].mass = in.readDouble();
            // Planetss[i].imgFileName = in.readString();
        }

        return Planetss;
    }

    public static void main(String[] args) {
        /** Collecting all needed input */
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        String fileName = args[2];

        Planet[] Planetss = readPlanets(fileName);
        double Radius = readRadius(fileName);

        /** Drawing the Background */
        StdDraw.enableDoubleBuffering();

        StdDraw.setScale(-Radius, Radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, imageBackground);
        StdDraw.show();

        for (int i = 0; i < Planetss.length; i++) {
            Planetss[i].draw();
        }
        StdDraw.show();

        for (double time = 0; time < T; time += dt) {
            double[] xForces = new double[Planetss.length];
            double[] yForces = new double[Planetss.length];

            StdDraw.clear();
            StdDraw.picture(0, 0, imageBackground);
            for (int i = 0; i < Planetss.length; i++) {
                xForces[i] = Planetss[i].calcNetForceExertedByX(Planetss);
                yForces[i] = Planetss[i].calcNetForceExertedByY(Planetss);
            }
            for (int i = 0; i < Planetss.length; i++) {
                Planetss[i].update(dt, xForces[i], yForces[i]);
                Planetss[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", Planetss.length);
        StdOut.printf("%.2e\n", Radius);
        for (int i = 0; i < Planetss.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planetss[i].xxPos, Planetss[i].yyPos, Planetss[i].xxVel,
                    Planetss[i].yyVel, Planetss[i].mass, Planetss[i].imgFileName);
        }
    }
}
