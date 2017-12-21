(defun permutations (list) 
	(if (= 1 (list-length list))
		(cons list ())
		(loop for c in list 
			append (map 'list (lambda (s) (cons c s)) (permutations (remove c list :test #'equal)))
		)
	)
)

(format t "~a" (permutations (coerce "ABC" 'list)))
