## How to use Registration Process
- deploy .jar from https://github.com/Stiehl-seine-Perlen/keycloak-custom-event-listener-Registration in Keycloak (/opt/keycloak/providers)
- log into Keycloak -> Go to corresponding Realm -> Realm Settings -> Events -> Event Listeners and activate the deployment
- Set env Variables (provided by Jan)
- Register in corresponding Realm and get Welcome E-Mail 🎉
  (E-Mail will also be send when user gets registered over Admin ui)

## Features
- Registration Process for sending a welcome E-Mail and later a recommendation E-Mail
- The Registration Process creates a PlatformUser in DB with correct Username & E-Mail
- PlatformUser API
