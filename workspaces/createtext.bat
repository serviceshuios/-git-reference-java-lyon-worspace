@echo off
rem Utilisation de la commande echo avec off/on pour
rem activer ou désactiver l'affichage des commandes
rem exécutées par le programme.

set content=%~2

if "%1" equ "" (
	echo [ERROR] Impossible d'executer, veuillez remplir les arguments 
	goto usage
)
if "%content%" neq "" (
	goto create
) else (
	goto usage
)

:create
echo %content% > %1.txt
goto end

:usage
echo [INFO] Usage : createtext filename filecontent
goto end

:end
@echo on