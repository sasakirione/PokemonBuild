package port

import com.google.firebase.auth.FirebaseAuth

class FirebaseAuth {
  def checkToken(userToken: String): String = {
    val user = FirebaseAuth.getInstance().verifyIdToken(userToken)
    user.getUid
  }
}
