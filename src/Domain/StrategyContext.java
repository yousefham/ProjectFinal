/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author yousef
 */
public class StrategyContext {

    private SearchStrategy Search;

    public StrategyContext(SearchStrategy Search) {
        this.Search = Search;
    }

    public String doIt(String type) {
        return type ;
    }

    public void DoSearch(String type) {
        Search.search(type);
    }
}
