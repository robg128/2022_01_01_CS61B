public class NBody {
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

    }
}
