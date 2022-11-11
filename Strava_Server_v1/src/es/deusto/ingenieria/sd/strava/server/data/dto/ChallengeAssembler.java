package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Challenge;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class ChallengeAssembler {
    private static ChallengeAssembler instance;

    private ChallengeAssembler() { }

    public static ChallengeAssembler getInstance() {
        if (instance == null) {
            instance = new ChallengeAssembler();
        }

        return instance;
    }

    public ChallengeDTO challengeToDTO(Challenge challenge) {
        ChallengeDTO dto = new ChallengeDTO();
        dto.setCycling(challenge.isCycling());
        dto.setDistance(challenge.getDistance());
        dto.setEndDate(challenge.getEndDate());
        dto.setName(challenge.getName());
        dto.setRunning(challenge.isRunning());
        dto.setStartDate(challenge.getStartDate());
        dto.setTime(challenge.getTime());

        return dto;
    }

    public List<ChallengeDTO> challengeToDTO(List<Challenge> challenges) {
        List<ChallengeDTO> dtos = new ArrayList<>();

        for (Challenge challenge : challenges) {
            dtos.add(this.challengeToDTO(challenge));
        }

        return dtos;
    }
}