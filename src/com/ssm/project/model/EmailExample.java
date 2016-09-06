package com.ssm.project.model;

import java.util.ArrayList;
import java.util.List;

public class EmailExample {
	protected String orderByClause;
	private Integer pageSize;
	private Integer recordIndex;
	private String recipients;
	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public EmailExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getRecordIndex() {
		return recordIndex;
	}

	public void setRecordIndex(Integer recordIndex) {
		this.recordIndex = recordIndex;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andEIdIsNull() {
			addCriterion("E_ID is null");
			return (Criteria) this;
		}

		public Criteria andEIdIsNotNull() {
			addCriterion("E_ID is not null");
			return (Criteria) this;
		}

		public Criteria andEIdEqualTo(Integer value) {
			addCriterion("E_ID =", value, "eId");
			return (Criteria) this;
		}

		public Criteria andEIdNotEqualTo(Integer value) {
			addCriterion("E_ID <>", value, "eId");
			return (Criteria) this;
		}

		public Criteria andEIdGreaterThan(Integer value) {
			addCriterion("E_ID >", value, "eId");
			return (Criteria) this;
		}

		public Criteria andEIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("E_ID >=", value, "eId");
			return (Criteria) this;
		}

		public Criteria andEIdLessThan(Integer value) {
			addCriterion("E_ID <", value, "eId");
			return (Criteria) this;
		}

		public Criteria andEIdLessThanOrEqualTo(Integer value) {
			addCriterion("E_ID <=", value, "eId");
			return (Criteria) this;
		}

		public Criteria andEIdIn(List<Integer> values) {
			addCriterion("E_ID in", values, "eId");
			return (Criteria) this;
		}

		public Criteria andEIdNotIn(List<Integer> values) {
			addCriterion("E_ID not in", values, "eId");
			return (Criteria) this;
		}

		public Criteria andEIdBetween(Integer value1, Integer value2) {
			addCriterion("E_ID between", value1, value2, "eId");
			return (Criteria) this;
		}

		public Criteria andEIdNotBetween(Integer value1, Integer value2) {
			addCriterion("E_ID not between", value1, value2, "eId");
			return (Criteria) this;
		}

		public Criteria andRecipientsIsNull() {
			addCriterion("RECIPIENTS is null");
			return (Criteria) this;
		}

		public Criteria andRecipientsIsNotNull() {
			addCriterion("RECIPIENTS is not null");
			return (Criteria) this;
		}

		public Criteria andRecipientsEqualTo(String value) {
			addCriterion("RECIPIENTS =", value, "recipients");
			return (Criteria) this;
		}

		public Criteria andRecipientsNotEqualTo(String value) {
			addCriterion("RECIPIENTS <>", value, "recipients");
			return (Criteria) this;
		}

		public Criteria andRecipientsGreaterThan(String value) {
			addCriterion("RECIPIENTS >", value, "recipients");
			return (Criteria) this;
		}

		public Criteria andRecipientsGreaterThanOrEqualTo(String value) {
			addCriterion("RECIPIENTS >=", value, "recipients");
			return (Criteria) this;
		}

		public Criteria andRecipientsLessThan(String value) {
			addCriterion("RECIPIENTS <", value, "recipients");
			return (Criteria) this;
		}

		public Criteria andRecipientsLessThanOrEqualTo(String value) {
			addCriterion("RECIPIENTS <=", value, "recipients");
			return (Criteria) this;
		}

		public Criteria andRecipientsLike(String value) {
			addCriterion("RECIPIENTS like", value, "recipients");
			return (Criteria) this;
		}

		public Criteria andRecipientsNotLike(String value) {
			addCriterion("RECIPIENTS not like", value, "recipients");
			return (Criteria) this;
		}

		public Criteria andRecipientsIn(List<String> values) {
			addCriterion("RECIPIENTS in", values, "recipients");
			return (Criteria) this;
		}

		public Criteria andRecipientsNotIn(List<String> values) {
			addCriterion("RECIPIENTS not in", values, "recipients");
			return (Criteria) this;
		}

		public Criteria andRecipientsBetween(String value1, String value2) {
			addCriterion("RECIPIENTS between", value1, value2, "recipients");
			return (Criteria) this;
		}

		public Criteria andRecipientsNotBetween(String value1, String value2) {
			addCriterion("RECIPIENTS not between", value1, value2, "recipients");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("TITLE is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("TITLE is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("TITLE =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("TITLE <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("TITLE >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("TITLE >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("TITLE <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("TITLE <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("TITLE like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("TITLE not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("TITLE in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("TITLE not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("TITLE between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("TITLE not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andContentIsNull() {
			addCriterion("CONTENT is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("CONTENT is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("CONTENT =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("CONTENT <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("CONTENT >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("CONTENT >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("CONTENT <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("CONTENT <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("CONTENT like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("CONTENT not like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("CONTENT in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("CONTENT not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("CONTENT between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("CONTENT not between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andSenderIsNull() {
			addCriterion("SENDER is null");
			return (Criteria) this;
		}

		public Criteria andSenderIsNotNull() {
			addCriterion("SENDER is not null");
			return (Criteria) this;
		}

		public Criteria andSenderEqualTo(String value) {
			addCriterion("SENDER =", value, "sender");
			return (Criteria) this;
		}

		public Criteria andSenderNotEqualTo(String value) {
			addCriterion("SENDER <>", value, "sender");
			return (Criteria) this;
		}

		public Criteria andSenderGreaterThan(String value) {
			addCriterion("SENDER >", value, "sender");
			return (Criteria) this;
		}

		public Criteria andSenderGreaterThanOrEqualTo(String value) {
			addCriterion("SENDER >=", value, "sender");
			return (Criteria) this;
		}

		public Criteria andSenderLessThan(String value) {
			addCriterion("SENDER <", value, "sender");
			return (Criteria) this;
		}

		public Criteria andSenderLessThanOrEqualTo(String value) {
			addCriterion("SENDER <=", value, "sender");
			return (Criteria) this;
		}

		public Criteria andSenderLike(String value) {
			addCriterion("SENDER like", value, "sender");
			return (Criteria) this;
		}

		public Criteria andSenderNotLike(String value) {
			addCriterion("SENDER not like", value, "sender");
			return (Criteria) this;
		}

		public Criteria andSenderIn(List<String> values) {
			addCriterion("SENDER in", values, "sender");
			return (Criteria) this;
		}

		public Criteria andSenderNotIn(List<String> values) {
			addCriterion("SENDER not in", values, "sender");
			return (Criteria) this;
		}

		public Criteria andSenderBetween(String value1, String value2) {
			addCriterion("SENDER between", value1, value2, "sender");
			return (Criteria) this;
		}

		public Criteria andSenderNotBetween(String value1, String value2) {
			addCriterion("SENDER not between", value1, value2, "sender");
			return (Criteria) this;
		}

		public Criteria andAccessoryIsNull() {
			addCriterion("ACCESSORY is null");
			return (Criteria) this;
		}

		public Criteria andAccessoryIsNotNull() {
			addCriterion("ACCESSORY is not null");
			return (Criteria) this;
		}

		public Criteria andAccessoryEqualTo(String value) {
			addCriterion("ACCESSORY =", value, "accessory");
			return (Criteria) this;
		}

		public Criteria andAccessoryNotEqualTo(String value) {
			addCriterion("ACCESSORY <>", value, "accessory");
			return (Criteria) this;
		}

		public Criteria andAccessoryGreaterThan(String value) {
			addCriterion("ACCESSORY >", value, "accessory");
			return (Criteria) this;
		}

		public Criteria andAccessoryGreaterThanOrEqualTo(String value) {
			addCriterion("ACCESSORY >=", value, "accessory");
			return (Criteria) this;
		}

		public Criteria andAccessoryLessThan(String value) {
			addCriterion("ACCESSORY <", value, "accessory");
			return (Criteria) this;
		}

		public Criteria andAccessoryLessThanOrEqualTo(String value) {
			addCriterion("ACCESSORY <=", value, "accessory");
			return (Criteria) this;
		}

		public Criteria andAccessoryLike(String value) {
			addCriterion("ACCESSORY like", value, "accessory");
			return (Criteria) this;
		}

		public Criteria andAccessoryNotLike(String value) {
			addCriterion("ACCESSORY not like", value, "accessory");
			return (Criteria) this;
		}

		public Criteria andAccessoryIn(List<String> values) {
			addCriterion("ACCESSORY in", values, "accessory");
			return (Criteria) this;
		}

		public Criteria andAccessoryNotIn(List<String> values) {
			addCriterion("ACCESSORY not in", values, "accessory");
			return (Criteria) this;
		}

		public Criteria andAccessoryBetween(String value1, String value2) {
			addCriterion("ACCESSORY between", value1, value2, "accessory");
			return (Criteria) this;
		}

		public Criteria andAccessoryNotBetween(String value1, String value2) {
			addCriterion("ACCESSORY not between", value1, value2, "accessory");
			return (Criteria) this;
		}

		public Criteria andIsreadIsNull() {
			addCriterion("ISREAD is null");
			return (Criteria) this;
		}

		public Criteria andIsreadIsNotNull() {
			addCriterion("ISREAD is not null");
			return (Criteria) this;
		}

		public Criteria andIsreadEqualTo(String value) {
			addCriterion("ISREAD =", value, "isread");
			return (Criteria) this;
		}

		public Criteria andIsreadNotEqualTo(String value) {
			addCriterion("ISREAD <>", value, "isread");
			return (Criteria) this;
		}

		public Criteria andIsreadGreaterThan(String value) {
			addCriterion("ISREAD >", value, "isread");
			return (Criteria) this;
		}

		public Criteria andIsreadGreaterThanOrEqualTo(String value) {
			addCriterion("ISREAD >=", value, "isread");
			return (Criteria) this;
		}

		public Criteria andIsreadLessThan(String value) {
			addCriterion("ISREAD <", value, "isread");
			return (Criteria) this;
		}

		public Criteria andIsreadLessThanOrEqualTo(String value) {
			addCriterion("ISREAD <=", value, "isread");
			return (Criteria) this;
		}

		public Criteria andIsreadLike(String value) {
			addCriterion("ISREAD like", value, "isread");
			return (Criteria) this;
		}

		public Criteria andIsreadNotLike(String value) {
			addCriterion("ISREAD not like", value, "isread");
			return (Criteria) this;
		}

		public Criteria andIsreadIn(List<String> values) {
			addCriterion("ISREAD in", values, "isread");
			return (Criteria) this;
		}

		public Criteria andIsreadNotIn(List<String> values) {
			addCriterion("ISREAD not in", values, "isread");
			return (Criteria) this;
		}

		public Criteria andIsreadBetween(String value1, String value2) {
			addCriterion("ISREAD between", value1, value2, "isread");
			return (Criteria) this;
		}

		public Criteria andIsreadNotBetween(String value1, String value2) {
			addCriterion("ISREAD not between", value1, value2, "isread");
			return (Criteria) this;
		}

		public Criteria andTimeIsNull() {
			addCriterion("TIME is null");
			return (Criteria) this;
		}

		public Criteria andTimeIsNotNull() {
			addCriterion("TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTimeEqualTo(String value) {
			addCriterion("TIME =", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotEqualTo(String value) {
			addCriterion("TIME <>", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeGreaterThan(String value) {
			addCriterion("TIME >", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeGreaterThanOrEqualTo(String value) {
			addCriterion("TIME >=", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeLessThan(String value) {
			addCriterion("TIME <", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeLessThanOrEqualTo(String value) {
			addCriterion("TIME <=", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeLike(String value) {
			addCriterion("TIME like", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotLike(String value) {
			addCriterion("TIME not like", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeIn(List<String> values) {
			addCriterion("TIME in", values, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotIn(List<String> values) {
			addCriterion("TIME not in", values, "time");
			return (Criteria) this;
		}

		public Criteria andTimeBetween(String value1, String value2) {
			addCriterion("TIME between", value1, value2, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotBetween(String value1, String value2) {
			addCriterion("TIME not between", value1, value2, "time");
			return (Criteria) this;
		}

		public Criteria andIsdeletedIsNull() {
			addCriterion("ISDELETED is null");
			return (Criteria) this;
		}

		public Criteria andIsdeletedIsNotNull() {
			addCriterion("ISDELETED is not null");
			return (Criteria) this;
		}

		public Criteria andIsdeletedEqualTo(Integer i) {
			addCriterion("ISDELETED =", i, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedNotEqualTo(Integer value) {
			addCriterion("ISDELETED <>", value, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedGreaterThan(Integer value) {
			addCriterion("ISDELETED >", value, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedGreaterThanOrEqualTo(Integer value) {
			addCriterion("ISDELETED >=", value, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedLessThan(Integer value) {
			addCriterion("ISDELETED <", value, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedLessThanOrEqualTo(Integer value) {
			addCriterion("ISDELETED <=", value, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedIn(List<Integer> values) {
			addCriterion("ISDELETED in", values, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedNotIn(List<Integer> values) {
			addCriterion("ISDELETED not in", values, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedBetween(Integer value1, Integer value2) {
			addCriterion("ISDELETED between", value1, value2, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedNotBetween(Integer value1, Integer value2) {
			addCriterion("ISDELETED not between", value1, value2, "isdeleted");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}