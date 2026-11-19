import unittest

class TestBankingLedger(unittest.TestCase):
    def test_double_entry_balance_invariant(self):
        acc1_bal = 1000.0
        acc2_bal = 500.0
        transfer = 200.0
        acc1_bal -= transfer
        acc2_bal += transfer
        self.assertEqual(acc1_bal, 800.0)
        self.assertEqual(acc2_bal, 700.0)
        self.assertEqual(acc1_bal + acc2_bal, 1500.0)

if __name__ == "__main__":
    unittest.main()
