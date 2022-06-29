import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.inject.AbstractModule

import java.io.{ByteArrayInputStream, FileInputStream, InputStream}

class Module extends AbstractModule {
  override def configure(): Unit = {
    // Firebase init
    val input = sys.env("FIREBASE_CONFIG")
    val inputStream: InputStream = new ByteArrayInputStream(input.getBytes)
    val options = FirebaseOptions.builder.
      setCredentials(GoogleCredentials.
        fromStream(inputStream)).
      build
    FirebaseApp.initializeApp(options)
  }
}
