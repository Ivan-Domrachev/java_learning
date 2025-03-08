package HomeWork.homeWork09.Races;

import HomeWork.homeWork09.Cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Race {
    private int LenghtTrack;
    private String Route;
    private int PrizeFund;
    private List<Car> Participants;

    public Race(){this.Participants = new ArrayList<>();}

    public Race(int LenghtTrack, String Route, int PrizeFund) {
        this.LenghtTrack = LenghtTrack;
        this.Route = Route;
        this.PrizeFund = PrizeFund;
        this.Participants = new ArrayList<>();
    }

    public int getLenghtTrack() {
        return LenghtTrack;
    }

    public void setLenghtTrack(int lenghtTrack) {
        LenghtTrack = lenghtTrack;
    }

    public String getRoute() {
        return Route;
    }

    public void setRoute(String route) {
        Route = route;
    }

    public int getPrizeFund() {
        return PrizeFund;
    }

    public void setPrizeFund(int prizeFund) {
        PrizeFund = prizeFund;
    }

    public List<Car> getParticipants() {
        return Participants;
    }

    public void setParticipants(List<Car> participants) {
        this.Participants = participants;
    }
    public abstract Car determineWinner();


    @Override
    public String toString() {
        return "Race{" +
                "LenghtTrack=" + LenghtTrack +
                ", Route='" + Route + '\'' +
                ", PrizeFund=" + PrizeFund +
                ", Participants=" + Participants +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race that = (Race) o;
        return LenghtTrack == that.LenghtTrack && PrizeFund == that.PrizeFund && Objects.equals(Route, that.Route) && Objects.equals(Participants, that.Participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LenghtTrack, Route, PrizeFund, Participants);
    }
}
