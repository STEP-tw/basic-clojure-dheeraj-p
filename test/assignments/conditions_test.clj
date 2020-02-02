(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator"
    (is (= :infinite (informative-divide 4 0)))))

(deftest harishchandra-test
  (testing "truthy value"
    (is (= 4 (harishchandra 4))))
  (testing "falsy value"
    (is (nil? (harishchandra false)))))

(deftest yudishtira-test
  (testing "truthy value"
    (is (= 4 (yudishtira 4))))
  (testing "falsey value"
    (is (= :ashwathama (yudishtira nil)))
    (is (= :ashwathama (yudishtira false)))))

(deftest duplicate-first-test
  (testing "duplicates first element of non-empty sequence"
    (is (= '(1 1 2 3) (duplicate-first [1 2 3]))))
  (testing "returns nil for empty sequence"
    (is (nil? (duplicate-first [])))))

(deftest five-point-someone-test
  (testing "returns :chetan-bhagat for y = 5"
    (is (= :chetan-bhagat (five-point-someone 2 5))))
  (testing "returns :satan-bhagat for x = 5"
    (is (= :satan-bhagat (five-point-someone 5 4))))
  (testing "returns :greece when x > y"
    (is (= :greece (five-point-someone 7 6))))
  (testing "returns :universe when anything else happens"
    (is (= :universe (five-point-someone 6 7)))))
