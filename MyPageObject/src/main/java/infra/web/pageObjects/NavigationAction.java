package infra.web.pageObjects;

@FunctionalInterface
public interface NavigationAction {

	public AbstractPageObject run();
	//public <T extends AbstractPageObject> T run();
}
