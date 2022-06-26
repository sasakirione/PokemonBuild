import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.{FirebaseApp, FirebaseOptions}
import com.google.inject.AbstractModule

import java.io.FileInputStream

class Module extends AbstractModule {
  override def configure(): Unit = {
    // Firebase init
    val serviceAccount = new FileInputStream("conf/octopus-cddb-firebase-adminsdk-tyiuh-7e0417e752.json")
    val options = new FirebaseOptions.Builder()
      .setCredentials(GoogleCredentials.fromStream(serviceAccount))
      .setDatabaseUrl("https://test-firebase-db.firebaseio.com")
      .build()
    FirebaseApp.initializeApp(options)
  }
}
