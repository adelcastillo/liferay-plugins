/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.samplealloymvc.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.samplealloymvc.model.Checkout;
import com.liferay.samplealloymvc.model.CheckoutModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Checkout service. Represents a row in the &quot;SAMVC_Checkout&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CheckoutModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CheckoutImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CheckoutImpl
 * @see Checkout
 * @see CheckoutModel
 * @generated
 */
@ProviderType
public class CheckoutModelImpl extends BaseModelImpl<Checkout>
	implements CheckoutModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a checkout model instance should use the {@link Checkout} interface instead.
	 */
	public static final String TABLE_NAME = "SAMVC_Checkout";
	public static final Object[][] TABLE_COLUMNS = {
			{ "checkoutId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "assetId", Types.BIGINT },
			{ "checkOutDate", Types.TIMESTAMP },
			{ "expectedCheckInDate", Types.TIMESTAMP },
			{ "actualCheckInDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("checkoutId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("assetId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("checkOutDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("expectedCheckInDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("actualCheckInDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table SAMVC_Checkout (checkoutId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,assetId LONG,checkOutDate DATE null,expectedCheckInDate DATE null,actualCheckInDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table SAMVC_Checkout";
	public static final String ORDER_BY_JPQL = " ORDER BY checkout.checkoutId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SAMVC_Checkout.checkoutId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.samplealloymvc.model.Checkout"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.samplealloymvc.model.Checkout"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.samplealloymvc.model.Checkout"));

	public CheckoutModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _checkoutId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCheckoutId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _checkoutId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Checkout.class;
	}

	@Override
	public String getModelClassName() {
		return Checkout.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("checkoutId", getCheckoutId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("assetId", getAssetId());
		attributes.put("checkOutDate", getCheckOutDate());
		attributes.put("expectedCheckInDate", getExpectedCheckInDate());
		attributes.put("actualCheckInDate", getActualCheckInDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long checkoutId = (Long)attributes.get("checkoutId");

		if (checkoutId != null) {
			setCheckoutId(checkoutId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long assetId = (Long)attributes.get("assetId");

		if (assetId != null) {
			setAssetId(assetId);
		}

		Date checkOutDate = (Date)attributes.get("checkOutDate");

		if (checkOutDate != null) {
			setCheckOutDate(checkOutDate);
		}

		Date expectedCheckInDate = (Date)attributes.get("expectedCheckInDate");

		if (expectedCheckInDate != null) {
			setExpectedCheckInDate(expectedCheckInDate);
		}

		Date actualCheckInDate = (Date)attributes.get("actualCheckInDate");

		if (actualCheckInDate != null) {
			setActualCheckInDate(actualCheckInDate);
		}
	}

	@Override
	public long getCheckoutId() {
		return _checkoutId;
	}

	@Override
	public void setCheckoutId(long checkoutId) {
		_checkoutId = checkoutId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getAssetId() {
		return _assetId;
	}

	@Override
	public void setAssetId(long assetId) {
		_assetId = assetId;
	}

	@Override
	public Date getCheckOutDate() {
		return _checkOutDate;
	}

	@Override
	public void setCheckOutDate(Date checkOutDate) {
		_checkOutDate = checkOutDate;
	}

	@Override
	public Date getExpectedCheckInDate() {
		return _expectedCheckInDate;
	}

	@Override
	public void setExpectedCheckInDate(Date expectedCheckInDate) {
		_expectedCheckInDate = expectedCheckInDate;
	}

	@Override
	public Date getActualCheckInDate() {
		return _actualCheckInDate;
	}

	@Override
	public void setActualCheckInDate(Date actualCheckInDate) {
		_actualCheckInDate = actualCheckInDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Checkout.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Checkout toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Checkout)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CheckoutImpl checkoutImpl = new CheckoutImpl();

		checkoutImpl.setCheckoutId(getCheckoutId());
		checkoutImpl.setCompanyId(getCompanyId());
		checkoutImpl.setUserId(getUserId());
		checkoutImpl.setUserName(getUserName());
		checkoutImpl.setCreateDate(getCreateDate());
		checkoutImpl.setModifiedDate(getModifiedDate());
		checkoutImpl.setAssetId(getAssetId());
		checkoutImpl.setCheckOutDate(getCheckOutDate());
		checkoutImpl.setExpectedCheckInDate(getExpectedCheckInDate());
		checkoutImpl.setActualCheckInDate(getActualCheckInDate());

		checkoutImpl.resetOriginalValues();

		return checkoutImpl;
	}

	@Override
	public int compareTo(Checkout checkout) {
		long primaryKey = checkout.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Checkout)) {
			return false;
		}

		Checkout checkout = (Checkout)obj;

		long primaryKey = checkout.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CheckoutModelImpl checkoutModelImpl = this;

		checkoutModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<Checkout> toCacheModel() {
		CheckoutCacheModel checkoutCacheModel = new CheckoutCacheModel();

		checkoutCacheModel.checkoutId = getCheckoutId();

		checkoutCacheModel.companyId = getCompanyId();

		checkoutCacheModel.userId = getUserId();

		checkoutCacheModel.userName = getUserName();

		String userName = checkoutCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			checkoutCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			checkoutCacheModel.createDate = createDate.getTime();
		}
		else {
			checkoutCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			checkoutCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			checkoutCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		checkoutCacheModel.assetId = getAssetId();

		Date checkOutDate = getCheckOutDate();

		if (checkOutDate != null) {
			checkoutCacheModel.checkOutDate = checkOutDate.getTime();
		}
		else {
			checkoutCacheModel.checkOutDate = Long.MIN_VALUE;
		}

		Date expectedCheckInDate = getExpectedCheckInDate();

		if (expectedCheckInDate != null) {
			checkoutCacheModel.expectedCheckInDate = expectedCheckInDate.getTime();
		}
		else {
			checkoutCacheModel.expectedCheckInDate = Long.MIN_VALUE;
		}

		Date actualCheckInDate = getActualCheckInDate();

		if (actualCheckInDate != null) {
			checkoutCacheModel.actualCheckInDate = actualCheckInDate.getTime();
		}
		else {
			checkoutCacheModel.actualCheckInDate = Long.MIN_VALUE;
		}

		return checkoutCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{checkoutId=");
		sb.append(getCheckoutId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", assetId=");
		sb.append(getAssetId());
		sb.append(", checkOutDate=");
		sb.append(getCheckOutDate());
		sb.append(", expectedCheckInDate=");
		sb.append(getExpectedCheckInDate());
		sb.append(", actualCheckInDate=");
		sb.append(getActualCheckInDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.samplealloymvc.model.Checkout");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>checkoutId</column-name><column-value><![CDATA[");
		sb.append(getCheckoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetId</column-name><column-value><![CDATA[");
		sb.append(getAssetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checkOutDate</column-name><column-value><![CDATA[");
		sb.append(getCheckOutDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedCheckInDate</column-name><column-value><![CDATA[");
		sb.append(getExpectedCheckInDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actualCheckInDate</column-name><column-value><![CDATA[");
		sb.append(getActualCheckInDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Checkout.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Checkout.class
		};
	private long _checkoutId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _assetId;
	private Date _checkOutDate;
	private Date _expectedCheckInDate;
	private Date _actualCheckInDate;
	private Checkout _escapedModel;
}