package day.leetcode_1600;
/*
 * @lc app=leetcode.cn id=1600 lang=java
 *
 * [1600] 王位继承顺序
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
// @lc code=start
//哈希构建树结构，多叉树前序遍历
public class ThroneInheritance {
    Map<String, List<String>> map = new HashMap<>();
    Set<String> dead = new HashSet<>();//记录死亡
    String root;
    //找位置，先序遍历，记录死亡人数
    public ThroneInheritance(String kingName) {
        root = kingName;
        map.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        List<String> list = map.getOrDefault(parentName, new ArrayList<>());
        list.add(childName);
        map.put(parentName, list);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        preOrder(ans,root);
        return ans;
    }
    public void preOrder(List<String> ans, String name){
        List<String> list = map.getOrDefault(name, new ArrayList());
        if(!dead.contains(name))
            ans.add(name);
        for(String cur:list)
            preOrder(ans, cur);
    }
}
/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
// @lc code=end

