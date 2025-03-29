Feature: Login Validations

  @AccountCreationSuccessfulWithUniqueFields
  Scenario: Account is created with randome firstName, lastName, email and password and the account creation is successful
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

  @AccountCreationSuccessfulWithDifferentMaildIdAndSameFields
  Scenario Outline: Account is recreated with same firstName, lastName password and random different email and the account creation is successful
    Given the user navigates to the software testing board home page
    Then the user Creates an Account
    When the user creates random mailId and stores it to {emailId1}
    When the user fills in the personal information with the following details:
      | First Name       | <firstName> |
      | Last Name        | <lastName>  |
      | Email            | {emailId1}  |
      | Password         | <password>  |
      | Confirm Password | <password>  |
    Then the user clicks on Create an Account button
    Then verfiy the account creation successful with the msg 'Thank you for registering with Main Website Store.'
    Then verify the contact details with the following data:
      | Name  | <firstName> <lastName> |
      | Email | {emailId1}             |
    When the user signs out of the account
    When the user creates random mailId and stores it to {emailId2}
    Then the user Creates an Account
    When the user fills in the personal information with the following details:
      | First Name       | <firstName> |
      | Last Name        | <lastName>  |
      | Email            | {emailId2}  |
      | Password         | <password>  |
      | Confirm Password | <password>  |
    Then the user clicks on Create an Account button
    Then verfiy the account creation successful with the msg 'Thank you for registering with Main Website Store.'
    Then verify the contact details with the following data:
      | Name  | <firstName> <lastName> |
      | Email | {emailId2}             |

    Examples: 
      | firstName | lastName | password      | confirmPassword |
      | Tim       | Walter   | JohnPaul@7419 | JohnPaul@7419   |

  @AccountCreationFailWithSameMaildIdAndSameFields
  Scenario Outline: Account is recreated with same firstName, lastName, password, email and the account creation failed
    Given the user navigates to the software testing board home page
    Then the user Creates an Account
    When the user creates random mailId and stores it to {emailId1}
    When the user fills in the personal information with the following details:
      | First Name       | <firstName> |
      | Last Name        | <lastName>  |
      | Email            | {emailId1}  |
      | Password         | <password>  |
      | Confirm Password | <password>  |
    Then the user clicks on Create an Account button
    Then verfiy the account creation successful with the msg 'Thank you for registering with Main Website Store.'
    Then verify the contact details with the following data:
      | Name  | <firstName> <lastName> |
      | Email | {emailId1}             |
    When the user signs out of the account
    Then the user Creates an Account
    When the user fills in the personal information with the following details:
      | First Name       | <firstName> |
      | Last Name        | <lastName>  |
      | Email            | {emailId1}  |
      | Password         | <password>  |
      | Confirm Password | <password>  |
    Then the user clicks on Create an Account button
    Then verfiy the account creation failed with the msg 'There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.'

    Examples: 
      | firstName | lastName | password      | confirmPassword |
      | Tim       | Walter   | JohnPaul@7419 | JohnPaul@7419   |

  @AccountCreationFailWithSameMaildIdAndDifferentFields
  Scenario: Account is recreated with random firstName, lastName, password and same password and the account creation failed
    Given the user navigates to the software testing board home page
    Then the user Creates an Account
    When the user creates random alphanumericString of size 8 and stores it to {firstName1}
    When the user creates random alphanumericString of size 10 and stores it to {lastName1}
    When the user creates random mailId and stores it to {emailId1}
    When the user creates random password of length 10 and stores it to {password1}
    When the user fills in the personal information with the following details:
      | First Name       | {firstName1} |
      | Last Name        | {lastName1}  |
      | Email            | {emailId1}   |
      | Password         | {password1}  |
      | Confirm Password | {password1}  |
    Then the user clicks on Create an Account button
    Then verfiy the account creation successful with the msg 'Thank you for registering with Main Website Store.'
    Then verify the contact details with the following data:
      | Name  | {firstName1} {lastName1} |
      | Email | {emailId1}               |
    When the user signs out of the account
    When the user creates random alphanumericString of size 8 and stores it to {firstName2}
    When the user creates random alphanumericString of size 10 and stores it to {lastName2}
    When the user creates random password of length 10 and stores it to {password2}
    Then the user Creates an Account
    When the user fills in the personal information with the following details:
      | First Name       | {firstName2} |
      | Last Name        | {lastName2}  |
      | Email            | {emailId1}   |
      | Password         | {password2}  |
      | Confirm Password | {password2}  |
    Then the user clicks on Create an Account button
    Then verfiy the account creation failed with the msg 'There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.'

  @SuccessfulLogin&Logout
  Scenario: Account creation successful, Sign out, Sign In with the created account details, Login is successful and the details are correct
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

  @RequiredFieldValidationsForSignIn
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

  @RequiredFieldValidations
  Scenario Outline: Required Field Validations
    Given the user navigates to the software testing board home page
    When the user Creates an Account
    When the user fills in the personal information with the following details:
      | First Name       | <firstName>       |
      | Last Name        | <lastName>        |
      | Email            | <emailId>         |
      | Password         | <password>        |
      | Confirm Password | <confirmPassword> |
    When the user clicks on Create an Account button
    Then the user sees the required field error msg on the following fields:
      | First Name       | <firstNameError>       |
      | Last Name        | <lastNameError>        |
      | Email            | <emailError>           |
      | Password         | <passwordError>        |
      | Confirm Password | <confirmPasswordError> |

    Examples: 
      | firstName | lastName | emailId                 | password     | confirmPassword | firstNameError            | lastNameError             | emailError                | passwordError             | confirmPasswordError               |
      |           | Paul     | john2434.paul@gmail.com | JohnPaul7419 | JohnPaul7419    | This is a required field. | NA                        | NA                        | NA                        | NA                                 |
      | John      |          | john2434.paul@gmail.com | JohnPaul7419 | JohnPaul7419    | NA                        | This is a required field. | NA                        | NA                        | NA                                 |
      | John      | Paul     |                         | JohnPaul7419 | JohnPaul7419    | NA                        | NA                        | This is a required field. | NA                        | NA                                 |
      | John      | Paul     | john2434.paul@gmail.com |              | JohnPaul7419    | NA                        | NA                        | NA                        | This is a required field. | Please enter the same value again. |
      | John      | Paul     | john2434.paul@gmail.com | JohnPaul7419 |                 | NA                        | NA                        | NA                        | NA                        | This is a required field.          |
      |           |          | john2434.paul@gmail.com | JohnPaul7419 | JohnPaul7419    | This is a required field. | This is a required field. | NA                        | NA                        | NA                                 |
      |           | Paul     |                         | JohnPaul7419 | JohnPaul7419    | This is a required field. | NA                        | This is a required field. | NA                        | NA                                 |
      |           | Paul     | john2434.paul@gmail.com |              | JohnPaul7419    | This is a required field. | NA                        | NA                        | This is a required field. | Please enter the same value again. |
      |           | Paul     | john2434.paul@gmail.com | JohnPaul7419 |                 | This is a required field. | NA                        | NA                        | NA                        | This is a required field.          |
      | John      |          |                         | JohnPaul7419 | JohnPaul7419    | NA                        | This is a required field. | This is a required field. | NA                        | NA                                 |
      | John      |          | john2434.paul@gmail.com |              | JohnPaul7419    | NA                        | This is a required field. | NA                        | This is a required field. | Please enter the same value again. |
      | John      |          | john2434.paul@gmail.com | JohnPaul7419 |                 | NA                        | This is a required field. | NA                        | NA                        | This is a required field.          |
      | John      | Paul     |                         |              | JohnPaul7419    | NA                        | NA                        | This is a required field. | This is a required field. | Please enter the same value again. |
      | John      | Paul     |                         | JohnPaul7419 |                 | NA                        | NA                        | This is a required field. | NA                        | This is a required field.          |
      | John      | Paul     | john2434.paul@gmail.com |              |                 | NA                        | NA                        | NA                        | This is a required field. | This is a required field.          |
      |           |          |                         | JohnPaul7419 | JohnPaul7419    | This is a required field. | This is a required field. | This is a required field. | NA                        | NA                                 |
      |           |          | john2434.paul@gmail.com |              | JohnPaul7419    | This is a required field. | This is a required field. | NA                        | This is a required field. | Please enter the same value again. |
      |           |          | john2434.paul@gmail.com | JohnPaul7419 |                 | This is a required field. | This is a required field. | NA                        | NA                        | This is a required field.          |
      |           | Paul     |                         |              | JohnPaul7419    | This is a required field. | NA                        | This is a required field. | This is a required field. | Please enter the same value again. |
      |           | Paul     |                         | JohnPaul7419 |                 | This is a required field. | NA                        | This is a required field. | NA                        | This is a required field.          |
      |           | Paul     | john2434.paul@gmail.com |              |                 | This is a required field. | NA                        | NA                        | This is a required field. | This is a required field.          |
      | John      |          |                         |              | JohnPaul7419    | NA                        | This is a required field. | This is a required field. | This is a required field. | Please enter the same value again. |
      | John      |          |                         | JohnPaul7419 |                 | NA                        | This is a required field. | This is a required field. | NA                        | This is a required field.          |
      | John      |          | john2434.paul@gmail.com |              |                 | NA                        | This is a required field. | NA                        | This is a required field. | This is a required field.          |
      | John      | Paul     |                         |              |                 | NA                        | NA                        | This is a required field. | This is a required field. | This is a required field.          |
      |           |          |                         |              | JohnPaul7419    | This is a required field. | This is a required field. | This is a required field. | This is a required field. | Please enter the same value again. |
      |           |          |                         | JohnPaul7419 |                 | This is a required field. | This is a required field. | This is a required field. | NA                        | This is a required field.          |
      |           |          | john2434.paul@gmail.com |              |                 | This is a required field. | This is a required field. | NA                        | This is a required field. | This is a required field.          |
      |           | Paul     |                         |              |                 | This is a required field. | NA                        | This is a required field. | This is a required field. | This is a required field.          |
      | John      |          |                         |              |                 | NA                        | This is a required field. | This is a required field. | This is a required field. | This is a required field.          |
      |           |          |                         |              |                 | This is a required field. | This is a required field. | This is a required field. | This is a required field. | This is a required field.          |

  @InvalidEmailFormatWhenCreatingAccount
  Scenario Outline: Invalid Email format when creating an account
    Given the user navigates to the software testing board home page
    When the user Creates an Account
    When the user fills in the personal information with the following details:
      | First Name       | <firstName>       |
      | Last Name        | <lastName>        |
      | Email            | <emailId>         |
      | Password         | <password>        |
      | Confirm Password | <confirmPassword> |
    When the user clicks on Create an Account button
    Then the user sees the required field error msg on the following fields:
      | First Name       | <firstNameError>       |
      | Last Name        | <lastNameError>        |
      | Email            | <emailError>           |
      | Password         | <passwordError>        |
      | Confirm Password | <confirmPasswordError> |

    Examples: 
      | firstName | lastName | emailId  | password     | confirmPassword | firstNameError            | lastNameError             | emailError                                                   | passwordError             | confirmPasswordError               |
      | John      | Paul     | john2434 | JohnPaul7419 | JohnPaul7419    | NA                        | NA                        | Please enter a valid email address (Ex: johndoe@domain.com). | NA                        | NA                                 |
      |           |          | john2434 |              |                 | This is a required field. | This is a required field. | Please enter a valid email address (Ex: johndoe@domain.com). | This is a required field. | This is a required field.          |
      |           |          | john2434 |              | JohnPaul7419    | This is a required field. | This is a required field. | Please enter a valid email address (Ex: johndoe@domain.com). | This is a required field. | Please enter the same value again. |

  @PasswordStrengthValidations
  Scenario Outline: Weak, Medium, Strong, Very Strong password validations
    Given the user navigates to the software testing board home page
    When the user Creates an Account
    When the user fills in the personal information with the following details:
      | First Name       | <firstName>       |
      | Last Name        | <lastName>        |
      | Email            | <emailId>         |
      | Password         | <password>        |
      | Confirm Password | <confirmPassword> |
    Then the user sees the required field error msg on the following fields:
      | Password | <passwordError> |
    Then the user checks the password strength to be <passwordStrength>

    Examples: 
      | firstName | lastName | emailId                 | password       | confirmPassword | passwordError                                                                                                                           | passwordStrength |
      | John      | Paul     | john2434.paul@gmail.com | john           | john            | Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.                      | Weak             |
      | John      | Paul     | john2434.paul@gmail.com | johnTEST       | johnTEST        | Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters. | Weak             |
      | John      | Paul     | john2434.paul@gmail.com | John1234       | John1234        | NA                                                                                                                                      | Medium           |
      | John      | Paul     | john2434.paul@gmail.com | John@12345     | John@12345      | NA                                                                                                                                      | Medium           |
      | John      | Paul     | john2434.paul@gmail.com | @Johntest      | @Johntest       | NA                                                                                                                                      | Strong           |
      | John      | Paul     | john2434.paul@gmail.com | @Johntesttry09 | @Johntesttry09  | NA                                                                                                                                      | Very Strong      |
