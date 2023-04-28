import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dheeraj.compose_testcase.LoginScreen
import com.dheeraj.compose_testcase.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun login_with_correct_credentials() {
        // Set up the test
        composeTestRule.setContent {
            MaterialTheme {
                LoginScreen { email, password ->
                    assert(email == "dheeraj@gmail.com" && password == "123456")
                }
            }
        }

        // Enter email and password
        composeTestRule.onNodeWithTag("EmailTextField")
            .performTextInput("dheeraj@gmail.com")
        composeTestRule.onNodeWithTag("PasswordTextField")
            .performTextInput("123456")

        // Click the login button
        composeTestRule.onNodeWithTag("LoginButton")
            .performClick()

        // Verify the success message is displayed
        composeTestRule.onNodeWithText("Login successful")
            .assertIsDisplayed()
    }

    @Test
    fun login_with_incorrect_credentials() {
        // Set up the test
        composeTestRule.setContent {
            MaterialTheme {
                LoginScreen { email, password ->
                    assert(email != "dheeraj@gmail.com" || password != "123456")
                }
            }
        }

        // Enter incorrect email and password
        composeTestRule.onNodeWithTag("EmailTextField")
            .performTextInput("test@gmail.com")
        composeTestRule.onNodeWithTag("PasswordTextField")
            .performTextInput("654321")

        // Click the login button
        composeTestRule.onNodeWithTag("LoginButton")
            .performClick()

        // Verify the error message is displayed
        composeTestRule.onNodeWithText("Wrong credentials")
            .assertIsDisplayed()
    }
}