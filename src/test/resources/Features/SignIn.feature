Feature: SignIn Validations

  @SignIn @Positive @SignInPositive @SuccessfulSignInAfterAccountCreation
  Scenario: SignIn attempt successful after successful creation of an account
    Given the user navigates to the software testing board home page
    Then the user Creates an Account
    When the user creates random alphanumericString of size 8 and stores it to {firstName}
    When the user creates random alphanumericString of size 10 and stores it to {lastName}
    When the user creates random mailId and stores it to {emailId}
    When the user creates random password of length 10 and stores it to {password}
    When the user fills in the personal information with the following details:
      | First Name       | {firstName} |
      | Last Name        | {lastName}  |
      | Email            | {emailId}   |
      | Password         | {password}  |
      | Confirm Password | {password}  |
    Then the user clicks on Create an Account button
    Then verfiy the account creation successful with the msg 'Thank you for registering with Main Website Store.'
    Then verify the contact details with the following data:
      | Name  | {firstName} {lastName} |
      | Email | {emailId}              |
    When the user signs out of the account
    Then the user SignsIn an Account
    When the user fills in the personal information with the following details on SignIn Page:
      | Email    | {emailId}  |
      | Password | {password} |
    Then the user clicks on SignIn button
    Then verify the contact details with the following data:
      | Name  | {firstName} {lastName} |
      | Email | {emailId}              |

  @SignIn @Negative @SignInNegative @RequiredFieldValidationsForSignIn
  Scenario Outline: Required Field Validations for Sign In
    Given the user navigates to the software testing board home page
    Then the user SignsIn an Account
    When the user fills in the personal information with the following details on SignIn Page:
      | Email    | <emailId>  |
      | Password | <password> |
    Then the user clicks on SignIn button
    Then the user sees the required field error msg on the following fields on SignIn Page:
      | Email    | <emailError>    |
      | Password | <passwordError> |

    Examples: 
      | emailId          | password      | emailError                | passwordError             |
      |                  |               | This is a required field. | This is a required field. |
      | test@example.com |               | NA                        | This is a required field. |
      |                  | JohnPaul@7419 | This is a required field. | NA                        |

  @SignIn @Negative @SignInNegative @SignInWithUnregisteredMailId
  Scenario: SignIn with unregistered mailId failed
    Given the user navigates to the software testing board home page
    Then the user Creates an Account
    When the user creates random alphanumericString of size 8 and stores it to {firstName}
    When the user creates random alphanumericString of size 10 and stores it to {lastName}
    When the user creates random mailId and stores it to {emailId}
    When the user creates random password of length 10 and stores it to {password}
    When the user fills in the personal information with the following details:
      | First Name       | {firstName} |
      | Last Name        | {lastName}  |
      | Email            | {emailId}   |
      | Password         | {password}  |
      | Confirm Password | {password}  |
    Then the user clicks on Create an Account button
    Then verfiy the account creation successful with the msg 'Thank you for registering with Main Website Store.'
    Then verify the contact details with the following data:
      | Name  | {firstName} {lastName} |
      | Email | {emailId}              |
    When the user signs out of the account
    Then the user SignsIn an Account
    When the user fills in the personal information with the following details on SignIn Page:
      | Email    | fakeMailTest@gmail.com |
      | Password | {password}             |
    Then the user clicks on SignIn button
    Then verfiy the signIn failed with the msg 'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.'

  @SignIn @Negative @SignInNegative @SignInWithWrongPassword
  Scenario: SignIn with wrong password failed
    Given the user navigates to the software testing board home page
    Then the user Creates an Account
    When the user creates random alphanumericString of size 8 and stores it to {firstName}
    When the user creates random alphanumericString of size 10 and stores it to {lastName}
    When the user creates random mailId and stores it to {emailId}
    When the user creates random password of length 10 and stores it to {password}
    When the user creates random password of length 10 and stores it to {fakePassword}
    When the user fills in the personal information with the following details:
      | First Name       | {firstName} |
      | Last Name        | {lastName}  |
      | Email            | {emailId}   |
      | Password         | {password}  |
      | Confirm Password | {password}  |
    Then the user clicks on Create an Account button
    Then verfiy the account creation successful with the msg 'Thank you for registering with Main Website Store.'
    Then verify the contact details with the following data:
      | Name  | {firstName} {lastName} |
      | Email | {emailId}              |
    When the user signs out of the account
    Then the user SignsIn an Account
    When the user fills in the personal information with the following details on SignIn Page:
      | Email    | {emailId}      |
      | Password | {fakePassword} |
    Then the user clicks on SignIn button
    Then verfiy the signIn failed with the msg 'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.'

  @SignIn @Negative @SignInNegative @InvalidEmailIdFormatForSignIn
  Scenario: SignIn with invalid mailId failed
    Given the user navigates to the software testing board home page
    Then the user SignsIn an Account
    When the user fills in the personal information with the following details on SignIn Page:
      | Email    | john      |
      | Password | John@1234 |
    Then the user clicks on SignIn button
    Then the user sees the required field error msg on the following fields on SignIn Page:
      | Email | Please enter a valid email address (Ex: johndoe@domain.com). |

  @SignIn @Negative @SignInNegative @ForgotPassword
  Scenario: Validation for Forgot Password
    Given the user navigates to the software testing board home page
    Then the user SignsIn an Account
    When the user fills in the personal information with the following details on SignIn Page:
      | Email | tejaswinidevi1999@gmail.com |
    Then the user clicks on Forgot Password
    Then the user fills in the personal information with the following details on Forgot Password Page:
      | Email | tejaswinidevi1999@gmail.com |
    Then the user clicks on Reset Password button
    Then verfiy the signIn failed with the msg 'If there is an account associated with tejaswinidevi1999@gmail.com you will receive an email with a link to reset your password.'

  @SignIn @Negative @SignInNegative @ForgotPasswordRequiredFieldValidations
  Scenario: Required Field validations for Forgot Password
    Given the user navigates to the software testing board home page
    Then the user SignsIn an Account
    Then the user clicks on Forgot Password
    Then the user fills in the personal information with the following details on Forgot Password Page:
      | Email |  |
    Then the user clicks on Reset Password button
    Then the user sees the required field error msg on the following fields on Forgot Password Page:
      | Email | This is a required field. |
