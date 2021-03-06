package wallin.software.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import wallin.software.ecommerce.mapper.ItemsMapper;
import wallin.software.ecommerce.model.Item;

@Repository
public class ItemsDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private ItemsMapper itemsMapper;
	private String ITEM_RETRIEVE_SQL = "SELECT \"ID\", \"Name\", \"Description\", \"Price\" FROM \"Commerce\".\"Items\" WHERE \"ID\" = :id";
	
	public Item retrieveItem(int id) {
		return namedParameterJdbcTemplate.query(ITEM_RETRIEVE_SQL, new MapSqlParameterSource().addValue("id", id), itemsMapper).get(0);
	}
}
