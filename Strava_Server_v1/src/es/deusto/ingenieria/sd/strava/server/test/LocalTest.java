package es.deusto.ingenieria.sd.strava.server.test;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;
import es.deusto.ingenieria.sd.strava.server.remote.IRemoteFacade;
import es.deusto.ingenieria.sd.strava.server.remote.RemoteFacade;

public class LocalTest {

	public static void main(String[] args) throws RemoteException {
		IRemoteFacade facade = new RemoteFacade();
		long token = 0l;
		String pasword = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");

		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);

		try {
			// Login (fails no registered athlete)
			facade.login("Peter Oben", pasword);
		} catch (Exception e) {
			System.err.println("\t# Error: " + e.getMessage());
		}

		try {
			Set<String> type = new HashSet<>();
			type.add("CYCLING");
			token = facade.register("peter.oben@gmail.com", "Peter Oben", pasword, new Date(), null, null, null, null);
			ChallengeDTO newChallenge = facade.createChallenge(token, "hike", formatter.parse("22-01-2022"), formatter.parse("23-12-2022"), 10f,
					null, type);
			List<ChallengeDTO> challenges = facade.getActiveChallenges(token);
			for (ChallengeDTO challenge : challenges) {
				System.err.println(challenge);
			}
			float challengeState = facade.getChallengeState(token, newChallenge.getId());
			System.err.println(challengeState);
			facade.logout(token);
		} catch (Exception e) {
			System.err.println("\t# Error: " + e.getMessage());
		}

		// Force exit to stop RMI Server
		System.exit(0);
	}
}