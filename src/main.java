public class main {
    public static void main(String[] args) throws Exception {
        long playerId = 76561199135594761L;

        apiCaller api = new apiCaller();
        api.getPlayerStats(playerId);
        api.generateStatisticsFile("Data");
        dataFile.readMatchData("Data");

    }
}