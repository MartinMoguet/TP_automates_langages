public class Main {
    public static void main(String[] args) throws Exception {
        Reseau reseau = new Reseau(BusReader.busReader("bdd/bus.json"),TramReader.tramReader("bdd/tram.xml"), TrainReader.trainReader("bdd/train.xml"));
        System.out.println(reseau);
    }
}
