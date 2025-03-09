# game-api

1️⃣ Install the JAR File.
Save the attached JAR file (myapp-1.0.jar) to a folder on your local system.
2️⃣ Navigate to the Folder.
Open a terminal or command prompt and go to the folder where you saved the JAR file:
3️⃣ Run the JAR File
java -jar game-api-0.0.1-SNAPSHOT.jar

run on localhost:8080

API Endpoints
1️⃣ User/Player Registration API.
POST http://localhost:8080/api/users/register
Example:
{
    "username":"shivam",
    "deviceId":"223",
    "platform":"iphone"
}

2️⃣ Game Progress Tracking API
POST http://localhost:8080/api/game/progress
Example: 
{
  "userId":"2",
  "level": 5,
  "rank": 2,
  "gold": 500,
  "cash": 200,
  "gems": 50,
  "rewards": [
    {
        "id":2,
      "name": "Diamond Sword"
    }
  ],
  "lastActiveTime": "2025-03-09T15:00:00Z",
  "country": "India"
}

Make sure Java (JDK 17+) is installed.

