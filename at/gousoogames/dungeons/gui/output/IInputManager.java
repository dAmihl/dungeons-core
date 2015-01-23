package at.gousoogames.dungeons.gui.output;

public interface IInputManager {

	public void handleInputMainMenu(InputContainer c);
	public void handleInputCharacterSheet(InputContainer c);
	public void handleInputRoom(InputContainer c);
	public void handleInputPlayerTurn(InputContainer c);
	public void handleInputPlayerInventory(InputContainer c);
	public void handleInputSkillset(InputContainer c);
}
