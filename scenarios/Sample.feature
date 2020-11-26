Feature: Google Search

  @Sample
  Scenario: Sample Test
    Given get 'https://www.google.com/'
    When search for 'qaf github infostretch'
    When search for 'Aaaaaaaaaaaaaaaaaaaaaaaaaaaa'