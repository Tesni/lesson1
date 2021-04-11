package lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;

public class Race {
    private final ArrayList<Stage> stages;
    private AtomicReference<Car> winner = new AtomicReference<>();
    private final CyclicBarrier racePreparations;
    private final CyclicBarrier raceStart;
    private final CyclicBarrier raceEnd;


    public ArrayList<Stage> getStages() {
        return stages;
    }

    public AtomicReference<Car> getWinner() {
        return winner;
    }

    public CyclicBarrier getRacePreparations() {
        return racePreparations;
    }

    public CyclicBarrier getRaceStart() {
        return raceStart;
    }

    public CyclicBarrier getRaceEnd() {
        return raceEnd;
    }

    public Race(int numberOfCompetitors, Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.racePreparations = new CyclicBarrier(numberOfCompetitors, () ->
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!"));
        this.raceStart = new CyclicBarrier(numberOfCompetitors, () ->
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"));
        this.raceEnd = new CyclicBarrier(numberOfCompetitors, () ->
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!"));
    }

}


