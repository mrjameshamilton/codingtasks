(defun is_balanced (s) (is_balanced_list (coerce s 'list)))

(defun is_balanced_list (l) (is_balanced_r l NIL))

(defun is_balanced_r (l stack)
    (cond
        ((and (eq NIL l) (eq NIL stack)) t)
        ((is_open (car l)) (is_balanced_r (cdr l) (cons (car l) stack)))
        ((is_pair (car stack) (car l)) (is_balanced_r (cdr l) (cdr stack)))
    )
)

(defun is_open (c) (member c '("(" "{" "[") :test #'string=))

(defun is_pair (a b)
    (cond
        ((and (string= a "(") (string= b ")")) t)
        ((and (string= a "{") (string= b "}")) t)
        ((and (string= a "[") (string= b "]")) t)
    )
)

(format t "T ~a~%" (is_balanced ""))
(format t "T ~a~%" (is_balanced "{[]}"))
(format t "T ~a~%" (is_balanced "{[()()]}"))
(format t "NIL ~a~%" (is_balanced "([)()]"))
(format t "NIL ~a~%" (is_balanced "]"))
(format t "NIL ~a~%" (is_balanced "{"))
