package hackerrank.adhoc;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
	private static final String KEY_ALGORITHM = "AES";
	private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	private static final Integer LENGTH = 128;

	public static String encrypt(String content, String password) {
		try {
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

			byte[] byteContent = content.getBytes("utf-8");

			cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));

			byte[] result = cipher.doFinal(byteContent);

			return Base64.getEncoder().encodeToString(result);
		} catch (Exception ex) {
			System.out.println("error " + ex.getLocalizedMessage());
		}
		return null;
	}

	private static SecretKeySpec getSecretKey(final String password) {
		KeyGenerator kg = null;
		try {
			kg = KeyGenerator.getInstance(KEY_ALGORITHM);
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(password.getBytes());
			kg.init(LENGTH, random);
			SecretKey secretKey = kg.generateKey();
			return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
		} catch (Exception ex) {
			System.out.println("error " + ex.getLocalizedMessage());
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(Encryption.encrypt("{\"serialNumber\":\"330503JD05000018060401001YDQBWEG\",\"status\":38}",
				"KYIDZQJKNCQRYEBARBKX"));
		// result :
		// Dr9eeRgmt9H9ltP48Sw+FkzHEDN4cr5Ub1c5FJyZ8PGE2hseA/uNZsKowvmC2iJP6FuuHuPiviR5gywPDtBhNg==
	}

}
