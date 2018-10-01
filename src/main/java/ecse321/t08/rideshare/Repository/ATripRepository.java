package ecse321.t08.rideshare.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecse321.t08.rideshare.Entity.ATrip;

@Repository
public class ATripRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
        public ATrip createATrip(int status, String cost, int startDate, int endDate, String startLocation, String stops, int vehicleId) {
            ATrip aTrip = new ATrip();
            aTrip.setStatus(status);
            aTrip.setCostPerStop(cost);
            aTrip.setStartDate(startDate);
            aTrip.setEndDate(endDate);
            aTrip.setStartLocation(startLocation);
            aTrip.setStops(stops);
            aTrip.setVehicleId(vehicleId);
            entityManager.persist(aTrip);
            return aTrip;
        }

    @Transactional
    public ATrip getTrip(int id) {
        ATrip trip = entityManager.find(ATrip.class, id);

        return trip;
    }
}
