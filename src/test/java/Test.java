import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.andreykka.dto.PricesDTO;

public class Test {

    String testJson = """
            {
                "status": {
                    "timestamp": "2023-06-19T19:36:59.273Z",
                    "error_code": 0,
                    "error_message": null,
                    "elapsed": 29,
                    "credit_count": 1,
                    "notice": null
                },
                "data": {
                    "BTC": {
                        "id": 1,
                        "name": "Bitcoin",
                        "symbol": "BTC",
                        "slug": "bitcoin",
                        "num_market_pairs": 10247,
                        "date_added": "2010-07-13T00:00:00.000Z",
                        "tags": [
                            "mineable",
                            "pow",
                            "sha-256",
                            "store-of-value",
                            "state-channel",
                            "coinbase-ventures-portfolio",
                            "three-arrows-capital-portfolio",
                            "polychain-capital-portfolio",
                            "binance-labs-portfolio",
                            "blockchain-capital-portfolio",
                            "boostvc-portfolio",
                            "cms-holdings-portfolio",
                            "dcg-portfolio",
                            "dragonfly-capital-portfolio",
                            "electric-capital-portfolio",
                            "fabric-ventures-portfolio",
                            "framework-ventures-portfolio",
                            "galaxy-digital-portfolio",
                            "huobi-capital-portfolio",
                            "alameda-research-portfolio",
                            "a16z-portfolio",
                            "1confirmation-portfolio",
                            "winklevoss-capital-portfolio",
                            "usv-portfolio",
                            "placeholder-ventures-portfolio",
                            "pantera-capital-portfolio",
                            "multicoin-capital-portfolio",
                            "paradigm-portfolio",
                            "bitcoin-ecosystem"
                        ],
                        "max_supply": 21000000,
                        "circulating_supply": 19406737,
                        "total_supply": 19406737,
                        "is_active": 1,
                        "infinite_supply": false,
                        "platform": null,
                        "cmc_rank": 1,
                        "is_fiat": 0,
                        "self_reported_circulating_supply": null,
                        "self_reported_market_cap": null,
                        "tvl_ratio": null,
                        "last_updated": "2023-06-19T19:35:00.000Z",
                        "quote": {
                            "USD": {
                                "price": 26622.839999781983,
                                "volume_24h": 12965315660.69046,
                                "volume_change_24h": 55.8156,
                                "percent_change_1h": -0.88702748,
                                "percent_change_24h": -0.04500279,
                                "percent_change_7d": 3.28343413,
                                "percent_change_30d": -1.66102758,
                                "percent_change_60d": -5.07824661,
                                "percent_change_90d": -5.4934915,
                                "market_cap": 516662454068.849,
                                "market_cap_dominance": 48.3094,
                                "fully_diluted_market_cap": 559079639995.42,
                                "tvl": null,
                                "last_updated": "2023-06-19T19:35:00.000Z"
                            }
                        }
                    },
                    "ETH": {
                        "id": 1027,
                        "name": "Ethereum",
                        "symbol": "ETH",
                        "slug": "ethereum",
                        "num_market_pairs": 7015,
                        "date_added": "2015-08-07T00:00:00.000Z",
                        "tags": [
                            "pos",
                            "smart-contracts",
                            "ethereum-ecosystem",
                            "coinbase-ventures-portfolio",
                            "three-arrows-capital-portfolio",
                            "polychain-capital-portfolio",
                            "binance-labs-portfolio",
                            "blockchain-capital-portfolio",
                            "boostvc-portfolio",
                            "cms-holdings-portfolio",
                            "dcg-portfolio",
                            "dragonfly-capital-portfolio",
                            "electric-capital-portfolio",
                            "fabric-ventures-portfolio",
                            "framework-ventures-portfolio",
                            "hashkey-capital-portfolio",
                            "kenetic-capital-portfolio",
                            "huobi-capital-portfolio",
                            "alameda-research-portfolio",
                            "a16z-portfolio",
                            "1confirmation-portfolio",
                            "winklevoss-capital-portfolio",
                            "usv-portfolio",
                            "placeholder-ventures-portfolio",
                            "pantera-capital-portfolio",
                            "multicoin-capital-portfolio",
                            "paradigm-portfolio",
                            "injective-ecosystem",
                            "layer-1"
                        ],
                        "max_supply": null,
                        "circulating_supply": 120208826.30512026,
                        "total_supply": 120208826.30512026,
                        "is_active": 1,
                        "infinite_supply": true,
                        "platform": null,
                        "cmc_rank": 2,
                        "is_fiat": 0,
                        "self_reported_circulating_supply": null,
                        "self_reported_market_cap": null,
                        "tvl_ratio": null,
                        "last_updated": "2023-06-19T19:35:00.000Z",
                        "quote": {
                            "USD": {
                                "price": 1719.985120367724,
                                "volume_24h": 5364025039.122921,
                                "volume_change_24h": 63.5799,
                                "percent_change_1h": -1.01807262,
                                "percent_change_24h": -1.19637528,
                                "percent_change_7d": -0.54487026,
                                "percent_change_30d": -5.54114263,
                                "percent_change_60d": -10.33023615,
                                "percent_change_90d": -4.22602728,
                                "market_cap": 206757392581.6751,
                                "market_cap_dominance": 19.335,
                                "fully_diluted_market_cap": 206757392581.68,
                                "tvl": null,
                                "last_updated": "2023-06-19T19:35:00.000Z"
                            }
                        }
                    }
                }
            }
            """;

    @org.junit.jupiter.api.Test
    public void test() throws JsonProcessingException {
        System.out.println(new ObjectMapper().readValue(testJson, PricesDTO.class));
    }
}
