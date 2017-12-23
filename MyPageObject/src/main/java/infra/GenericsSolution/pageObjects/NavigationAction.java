package infra.GenericsSolution.pageObjects;

@FunctionalInterface
public interface NavigationAction {

	public AbstractPageObject run();
	//public <T extends AbstractPageObject> T run();
}
