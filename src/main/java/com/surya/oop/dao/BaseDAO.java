package com.surya.oop.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.surya.oop.dao.util.EclipseLinkUtil;
import com.surya.oop.po.BasePO;

public class BaseDAO<PO extends BasePO> implements IBaseDAO<PO> {
	private final Class<PO> persistentClass;
	
	public BaseDAO(Class<PO> poClass) {
		this.persistentClass = poClass;
	}
	
	protected String getPOClassName() {
		return persistentClass.getSimpleName();
	}
	
	protected Class<PO> getPOClass() {
		return persistentClass;
	}
	
	protected EntityManager getEM() {
		return EclipseLinkUtil.getEntityManager();
	}

	@Override
	public PO findById(long id) {
		Query q = getEM().createQuery("select o from " + getPOClassName() + " o where id = ?");
		q.setParameter(1, id);

		return null;
	}

	@Override
	public List<PO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PO persist(PO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PO po) {
		// TODO Auto-generated method stub

	}

	protected <T> List<T> find(String queryString) {
		return find(queryString, null, false);
	}

	protected <T> List<T> find(String queryString, boolean isNative) {
		return find(queryString, null, isNative);
	}

	protected <T> List<T> find(final String queryString, final Object values[],
			boolean isNative) {
		return find(queryString, values, isNative, null, null);
	}

	protected <T> List<T> find(final String queryString, final Object values[],
			boolean isNative, Integer start, Integer end) {
		Query queryObject = isNative ? getEM().createNativeQuery(queryString)
				: getEM().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i + 1, values[i]);
			}
		}
		if (start != null) {
			queryObject.setFirstResult(start);
		}
		if (end != null) {
			queryObject.setMaxResults(end);
		}
		@SuppressWarnings("unchecked")
		List<T> resultList = queryObject.getResultList();
		return resultList;
	}

	protected <T> List<T> findByNamedParams(final String queryString,
			final Map<String, ?> params, boolean isNative) {
		Query queryObject;
		if (isNative) {
			queryObject = getEM().createNativeQuery(queryString);
		} else {
			queryObject = getEM().createQuery(queryString);
		}

		if (params != null) {
			for (Map.Entry<String, ?> entry : params.entrySet()) {
				queryObject.setParameter(entry.getKey(), entry.getValue());
			}
		}
		@SuppressWarnings("unchecked")
		List<T> resultList = queryObject.getResultList();
		return resultList;
	}

	protected <T> List<T> findResultClassByNativeQuery(
			final String queryString, final Object values[],
			Class<T> resultClass) {
		Query queryObject = getEM().createNativeQuery(queryString, resultClass);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i + 1, values[i]);
			}
		}
		@SuppressWarnings("unchecked")
		List<T> resultList = queryObject.getResultList();
		return resultList;
	}

	protected <T> List<T> findResultClassByNativeNamedParams(
			final String queryString, final Map<String, Object> params,
			Class<T> resultClass) {
		Query queryObject = getEM().createNativeQuery(queryString, resultClass);
		if (params != null) {
			Map.Entry<String, Object> entry;
			for (Iterator<Map.Entry<String, Object>> it = params.entrySet()
					.iterator(); it.hasNext(); queryObject.setParameter(
					entry.getKey(), entry.getValue())) {
				entry = it.next();
			}

		}
		@SuppressWarnings("unchecked")
		List<T> resultList = queryObject.getResultList();
		return resultList;

	}

}
