package misc


import javax.crypto.spec.DESedeKeySpec
import javax.crypto.{Cipher, SecretKey, SecretKeyFactory}
import org.apache.commons.codec.binary.Base64

/**
 * Encrypts or decrypts the security key
 * Created by Abhisek Bastia on 6/30/2020.
 */
object SecurityKeyGenerator {

  //Key should be 24 characters
  val myEncryptionKey: String = "helloabhikeygeneratorhi"
  val UNICODE_FORMAT: String = "UTF8"
  val arrayBytes: Array[Byte] = myEncryptionKey.getBytes(UNICODE_FORMAT)
  val ks: DESedeKeySpec = new DESedeKeySpec(arrayBytes)
  val myEncryptionScheme: String = "DESede"
  val skf: SecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme)
  val cipher: Cipher = Cipher.getInstance(myEncryptionScheme)
  val key: SecretKey = skf.generateSecret(ks)

  def main(args: Array[String]): Unit = {
    val securityKey = "password"
    val encrypted = encrypt(securityKey)
    val decrypted = decrypt(encrypted)
    println("String To Encrypt: " + securityKey)
    println("Encrypted String:" + encrypted)
    println("Decrypted String:" + decrypted)
  }

  private def encrypt(unencryptedString: String): String = {

    try {
      cipher.init(Cipher.ENCRYPT_MODE, key)
      val plainText = unencryptedString.getBytes(UNICODE_FORMAT)
      val encryptedText = cipher.doFinal(plainText)
      new String(Base64.encodeBase64(encryptedText))
    } catch {
      case e: Exception =>
        e.printStackTrace()
        throw new Exception(s"Encryption is failed due to ${e.getMessage}")
    }
  }

  private def decrypt(encryptedString: String): String = {
    try {
      cipher.init(Cipher.DECRYPT_MODE, key)
      val encryptedText = Base64.decodeBase64(encryptedString)
      val plainText: Array[Byte] = cipher.doFinal(encryptedText)
      new String(plainText)
    } catch {
      case e: Exception =>
        e.printStackTrace()
        throw new Exception(s"Decryption is failed due to ${e.getMessage}")
    }
  }
}
