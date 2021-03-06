/**
 * This class file was automatically generated by jASN1 v1.8.1 (http://www.openmuc.org)
 */

package com.veon.rafm.roamingfraud.processors.NrtrdeDecodeProcessor.nrtrde;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;


public class DataVolumeIncoming extends BerInteger {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 28);

	public DataVolumeIncoming() {
	}

	public DataVolumeIncoming(byte[] code) {
		super(code);
	}

	public DataVolumeIncoming(BigInteger value) {
		super(value);
	}

	public DataVolumeIncoming(long value) {
		super(value);
	}

	public int encode(BerByteArrayOutputStream os, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			if (withTag) {
				return tag.encode(os) + code.length;
			}
			return code.length;
		}

		int codeLength;

		codeLength = super.encode(os, false);
		if (withTag) {
			codeLength += tag.encode(os);
		}

		return codeLength;
	}

	public int decode(InputStream is, boolean withTag) throws IOException {

		int codeLength = 0;

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		codeLength += super.decode(is, false);

		return codeLength;
	}

}
