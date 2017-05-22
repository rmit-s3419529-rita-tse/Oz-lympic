import java.util.ArrayList;

public class ParticipantHandler implements IParticipant {

	private IParticipant dbMode;
	private IParticipant fileMode;
	private String filepath;
	
	public ParticipantHandler(String filepath)
	{
		this.filepath = filepath;
	}
	
	@Override
	public Boolean AddParticipants(String ID, String strType, String strName, Integer Age, String State) {
		try
		{
			dbMode = new DbParticipant();
			return dbMode.AddParticipants(ID, strType, strName, Age, State);
		}
		catch(Exception e)
		{
			fileMode = new FileParticipant(this.filepath);
			return fileMode.AddParticipants(ID, strType, strName, Age, State);
		}
	}

	@Override
	public void DeleteParticipants() {
		try
		{
			dbMode = new DbParticipant();
			dbMode.DeleteParticipants();
		}
		catch(Exception e)
		{
			fileMode = new FileParticipant(this.filepath);
			fileMode.DeleteParticipants();
		}
	}

	@Override
	public void PrintParticipants() {
		try
		{
			dbMode = new DbParticipant();
			dbMode.PrintParticipants();
		}
		catch(Exception e)
		{
			try
			{
				fileMode = new FileParticipant(this.filepath);
				fileMode.PrintParticipants();
			}
			catch(Exception ex)
			{
				throw ex;
			}
		}
	}

	@Override
	public ArrayList<Participant> GetParticipants(String type) {
		try
		{
			dbMode = new DbParticipant();
			return dbMode.GetParticipants(type);
		}
		catch(Exception e)
		{
			fileMode = new FileParticipant(this.filepath);
			return fileMode.GetParticipants(type);
		}
	}

}
