import models.Vote;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Bootstrap extends Job {

    @Override
    public void doJob() throws Exception {

        for (int i = 0; i < 81; i++) {

                int j =(int)Math.floor(Math.random() * 10) + 1;
                new Vote("eylul", String.valueOf(i),j).save();
                j =(int)Math.floor(Math.random() * 10) + 1;
                new Vote("CHP", String.valueOf(i),j).save();
                j =(int)Math.floor(Math.random() * 10) + 1;
                new Vote("MHP", String.valueOf(i),j).save();
                j =(int)Math.floor(Math.random() * 10) + 1;
                new Vote("Diger", String.valueOf(i),j).save();
        }
    }
}
