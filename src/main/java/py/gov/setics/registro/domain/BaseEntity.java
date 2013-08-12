package py.gov.setics.registro.domain;

import org.apache.commons.lang.StringUtils;

import py.gov.setics.registro.util.ReflectionUtil;

public abstract class BaseEntity<I> {

	public abstract I getId();

	@Override
	public String toString() {
		return toString(true);
	}

	public String toString(boolean conHash) {
		String ret = ReflectionUtil.describe(this, conHash);
		if (StringUtils.isBlank(ret))
			ret = super.toString();
		return ret;
	}
}
