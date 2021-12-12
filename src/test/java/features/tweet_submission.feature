Feature: Test the tweet submission feature

  @Characters
  Scenario:Verify writing a tweet with more than limit of characters
    Given User open the website and go to login page and enter valid credentials email & password

    When User enter more than 280 characters inside tweet box
    Then tweet button should unclickable and red warning appear below tweet box and characters are highlighted in red

  @Images
  Scenario:Verify adding more than 4 images to a tweet
    Given User open the website and go to login page and enter valid credentials email & password
    When User add more than 4 images to one tweet
    Then An error message should appear saying 'please add 1 GIF or up to 4 photos'

  @Poll
  Scenario:Verify creating a poll in a tweet
    Given User open the website and go to login page and enter valid credentials email & password
    When User Create Poll
      | How Are you today? | fine | Bad |
    Then poll appear on his personal page