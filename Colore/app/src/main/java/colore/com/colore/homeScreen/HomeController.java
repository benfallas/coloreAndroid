package colore.com.colore.homeScreen;

public class HomeController {

    private HomeActivity mHomeActivity;
    private HomeLayout mHomeLayout;

    public HomeController(HomeActivity homeActivity) {
        mHomeActivity = homeActivity;
        mHomeLayout = new HomeLayout(mHomeActivity);
    }
}
